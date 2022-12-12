package discordbot;

import net.dv8tion.jda.api.EmbedBuilder;
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
import net.dv8tion.jda.api.utils.FileUpload;

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
        EmbedBuilder embed = new EmbedBuilder();
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
            FileUpload.fromData(spaargeld);
            channel.sendMessage("`" + textBlock + "`").queue();
            channel.sendFiles(FileUpload.fromData(spaargeld)).queue();
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
            FileUpload.fromData(whileOef6);
            channel.sendFiles(FileUpload.fromData(whileOef6)).queue();
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
            FileUpload.fromData(gemeneDeler);
            channel.sendFiles(FileUpload.fromData(gemeneDeler)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().equals("priem") || content.toLowerCase().equals("4")) {
            File priem = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\4. Oefening4PriemGetallen.txt");
            System.out.println("Oef4 Priem Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(priem);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(priem);
            channel.sendFiles(FileUpload.fromData(priem)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("beginwaarde eindwaarde") || content.toLowerCase().equals("3")) {
            File beginEind = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\3. Oefening3BeginEindWhile.txt");
            System.out.println("Oef3 Begin/Eindwaarde Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(beginEind);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(beginEind);
            channel.sendFiles(FileUpload.fromData(beginEind)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("input stop") || content.toLowerCase().equals("2")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\2. Oefening2InputEqualsStop.txt");
            System.out.println("Oef2 Input/Stop Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("rijen1") || content.toLowerCase().equals("8")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\8. Oefening1GetallenOpRijen.java");
            System.out.println("Oef Rijen Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("rijen2") || content.toLowerCase().equals("9")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\9. Oefening2GetallenOpRijen2.java");
            System.out.println("Oef GetallenOpRijen Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("maaltafels") || content.toLowerCase().equals("10")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\10. Oefening3MaalTafels.java");
            System.out.println("Oef MaalTafels Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("sterren") || content.toLowerCase().equals("11")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\11. Oefening4StarsSterrekes.java");
            System.out.println("Oef Sterren Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("gemiddelde") || content.toLowerCase().equals("12")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\12. Oefening5Gemiddelde.java");
            System.out.println("Oef Gemiddelde Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("faculteit") || content.toLowerCase().equals("13")) {
            File inputStop = new File("G:\\Git\\EGDiscordBot\\src\\JavaTaken\\13. Oefening6Faculteit.java");
            System.out.println("Oef faculteit Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(inputStop);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                String line = txtIn.nextLine();
                textBlock.append(line).append("\n");
            }
            event.getJDA().removeEventListener(this);
            channel.sendMessage("`" + textBlock + "`").queue();
            FileUpload.fromData(inputStop);
            channel.sendFiles(FileUpload.fromData(inputStop)).queue();
        }
        else event.getJDA().removeEventListener(this);
    }
}
