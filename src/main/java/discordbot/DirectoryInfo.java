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

    public CharSequence readDirectory(MessageReceivedEvent event) {
        File dir = new File("G:/Git/EGDiscordBot/src/JavaTaken");
        MessageChannel channel = event.getChannel();
        String s = "";
        if (dir.exists()) {
            dirName = dir.getName();
            File[] files = dir.listFiles();

            assert files != null;
            for (File file : files) {
                if (file.isDirectory()) {
                    childName = file.getName();
                    channel.sendMessage("\t" + childName).queue();
                }
                //if there's a file, print name
                if (file.isFile()) {
                    fileName = file.getName();
                     s += fileName.replace(".txt","") + "\n";

                }
            }
            channel.sendMessage("\t" + s).queue();
            //make child directory the new parent/current directory and repeat
            dir = new File(dir, childName);
        }
        return null;
    }
}