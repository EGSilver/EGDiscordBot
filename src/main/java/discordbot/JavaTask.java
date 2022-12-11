package discordbot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javafx.stage.DirectoryChooser;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaTask extends ListenerAdapter {
    private final long channelId, authorId;

    public JavaTask(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // stops the bots from responding to itself.
        DirectoryInfo scan = new DirectoryInfo();
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        Member member = message.getMember();
        StringBuilder textBlock = new StringBuilder();
        String content = event.getMessage().getContentRaw();
        if (event.getAuthor().getIdLong() == authorId && content.equals("spaargeld") || content.equals("7") || content.equals("Oefening5")) {
            File spaargeld = new File("G:/Git/EGDiscordBot/src/JavaTaken/7. Oefening7Spaargeld.txt");
            System.out.println("Oef7 Spaargeld Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(spaargeld);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.equals("optellenmetrest") || content.equals("6")) {
            File whileOef6 = new File("G:/Git/EGDiscordBot/src/JavaTaken/6. Oefening6GetalOptellenMetRest.txt");
            System.out.println("Oef6 optellenmetrest Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(whileOef6);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().equals("gemenedeler") || content.toLowerCase().equals("5")) {
            File gemeneDeler = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\5. Oefening5GrootstGemeneDeler.txt");
            System.out.println("Oef5 GemeneDeler Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(gemeneDeler);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().equals("priem") || content.toLowerCase().equals("4")) {
            File gemeneDeler = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\4. Oefening4PriemGetallen.txt");
            System.out.println("Oef4 Priem Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(gemeneDeler);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("beginwaarde eindwaarde") || content.toLowerCase().equals("3")) {
            File gemeneDeler = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\3. Oefening3BeginEindWhile.txt");
            System.out.println("Oef3 Begin/Eindwaarde Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(gemeneDeler);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("input stop") || content.toLowerCase().equals("2")) {
            File gemeneDeler = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\2. Oefening2InputEqualsStop.txt");
            System.out.println("Oef2 Input/Stop Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(gemeneDeler);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            channel.sendFiles().queue();
        }
        else event.getJDA().removeEventListener(this);
    }
}
