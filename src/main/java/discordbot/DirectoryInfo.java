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
        if (dir.exists()) {
            dirName = dir.getName();
            File[] files = dir.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    childName = files[i].getName();
                    channel.sendMessage("\t" + childName).queue();
                }
                //if there's a file, print name
                if (files[i].isFile()) {
                    fileName = files[i].getName();
                    channel.sendMessage("\t" + fileName).queue();
                }
            }
            //make child directory the new parent/current directory and repeat
            dir = new File(dir, childName);
        }
        return null;
    }
}