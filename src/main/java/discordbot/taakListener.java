package discordbot;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taakListener extends ListenerAdapter {
    private final long channelId, authorId;

    public taakListener(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //TODO fix bug that stops listening before the user has responded
        if (event.getAuthor().isBot()) return; // stops the bots from responding to itself.
        MessageChannel channel = event.getChannel();
        String content = event.getMessage().getContentRaw();
        if (content.equals("0")) {
            event.getJDA().removeEventListener(this); // stops listening.
        } if (event.getAuthor().getIdLong() == authorId && content.equals("1") || event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("java")) {
            channel.sendMessage("Welke oplossing van Java?").queue();
        }
        if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("spaargeld") || content.toLowerCase().contains("while oef7")) {
            int lineNumber = 1;
            File spaargeld = new File("G:/Git/EGDiscordBot/src/JavaTaken/spaargeld.txt");
            System.out.println("Oef7 Spaargeld Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(spaargeld);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                System.out.println(txtIn);
                String line = txtIn.nextLine();
                channel.sendMessage("`" + line + "`").queue();
                event.getJDA().removeEventListener(this);
            }
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("optellenmetrest") || content.toLowerCase().contains("while oef6")) {
            File whileOef6 = new File("G:/Git/EGDiscordBot/src/JavaTaken/Oefening6GetalOptellenMetRest.txt");
            System.out.println("Oef6 optellenmetrest Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(whileOef6);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                System.out.println(txtIn);
                String line = txtIn.nextLine();
                channel.sendMessage("`" + line + "`").queue();
                event.getJDA().removeEventListener(this);
            }
        } else if (event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("gemenedeler") || content.toLowerCase().contains("while oef5")) {
            File gemeneDeler = new File("G:/Git/EGDiscordBot/src/JavaTaken/Oefening5GrootstGemeneDeler.txt");
            System.out.println("Oef5 GemeneDeler Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(gemeneDeler);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                System.out.println(txtIn);
                String line = txtIn.nextLine();
                channel.sendMessage("`" + line + "`").queue();
                event.getJDA().removeEventListener(this);
            }
        } if (event.getAuthor().
                getIdLong() == authorId && content.equals("2") || event.getAuthor().
                getIdLong() == authorId && content.toLowerCase().
                contains("nosql")) {
            channel.sendMessage("Welke oplossing van NoSQL?").queue();
            event.getJDA().removeEventListener(this);
        } if (event.getAuthor().
                getIdLong() == authorId && content.equals("3") || event.getAuthor().
                getIdLong() == authorId && content.toLowerCase().
                contains("project")) {
            channel.sendMessage("Welke oplossing van Project?").queue();
            event.getJDA().removeEventListener(this);
        } if (event.getAuthor().
                getIdLong() == authorId && content.equals("4") || event.getAuthor().
                getIdLong() == authorId && content.toLowerCase().
                contains("ui")) {
            channel.sendMessage("Welke oplossing van UI?").queue();
            event.getJDA().removeEventListener(this);
        } else {
            event.getJDA().removeEventListener(this);
        }
    }
}

