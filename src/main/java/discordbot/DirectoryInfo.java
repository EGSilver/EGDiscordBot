package discordbot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class DirectoryInfo extends ListenerAdapter {
    String dirName = "";
    String childName = "";
    String fileName = "";

    public CharSequence readDirectory(MessageReceivedEvent event, File directory) {
        MessageChannel channel = event.getChannel();
        String s = "";
        if (directory.exists()) {
            dirName = directory.getName();
            File[] files = directory.listFiles();

            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    childName = file.getName();
                    channel.sendMessage("\t" + childName).queue();
                }
                //if there's a file, print name
                if (file.isFile()) {
                    fileName = file.getName();
                    if (fileName.contains(".txt")) {
                        s += fileName.replace(".txt", "") + "\n";
                    } else {
                        s += fileName.replace(".java", "") + "\n";
                    }
                }
                directory = new File(directory, childName);
            }
            channel.sendMessage("`\n" + s + "\n`").queue();
            //make child directory the new parent/current directory and repeat
        }
        return null;
    }
}