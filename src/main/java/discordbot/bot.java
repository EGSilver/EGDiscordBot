package discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Objects;
import java.util.Scanner;


public class bot extends ListenerAdapter {
    private static final String BOT_TOKEN = "";

    public static void main(String[] arguments) throws FileNotFoundException {
        JDA api = JDABuilder.createLight(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new bot())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String content = message.getContentRaw();
        String nickname = Objects.requireNonNull(message.getMember()).getNickname();
        Duration thirtySeconds = Duration.ofSeconds(30);
        Member member = message.getMember();
        MessageChannel channel = event.getChannel();
        if (event.getAuthor().isBot()) return;

        if (content.toLowerCase().equals("!ping") && !event.getAuthor().isBot()) {
            channel.sendMessage("Pong!").queue();
        }
        if (content.toLowerCase().equals("!marco") && !event.getAuthor().isBot()) {
            channel.sendMessage("!Polo").queue();
        } else if (content.toLowerCase().equals("!polo")) {
            channel.sendMessage("!Marco").queue();
        }
        if (content.toLowerCase().equals("hi") || content.toLowerCase().equals("hello") || content.toLowerCase().equals("hey")) {
            System.out.println("Welcome message");
            System.out.println(message.getMember().getNickname());
            channel.sendMessage("Hallo " + nickname).queue();
        }
        if (content.toLowerCase().contains("fuck") || content.toLowerCase().contains("shit")) {
            message.getMember().timeoutFor(Duration.ofSeconds(30)).queue();
            channel.sendMessage(message.getMember().getEffectiveName() + " You said the word " + message + " You have been timed out for " + thirtySeconds).queue();
        }
        if (content.startsWith("!oplossing") || content.startsWith("!taak")) {
            channel.sendMessage("typ meteen de naam van de taak, of kies Welk vak?\n1. Java\n2. NoSQL\n3. Project\n4. UI\n").queue();
            event.getJDA().addEventListener(new taakListener(channel, member.getUser()));
        }
        if (content.toLowerCase().equals("!help")) {
            int lineNumber = 1;
            File help = new File("G:/Git/EGDiscordBot/src/JavaTaken/help.txt");
            System.out.println("help file Loaded.");
            Scanner txtIn = null;
            try {
                txtIn = new Scanner(help);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (txtIn.hasNextLine()) {
                System.out.println(txtIn);
                String line = txtIn.nextLine();
                String s = line.replace("\n","");
                channel.sendMessage("`" + s + "`").queue();
            }
        }
        if (content.toLowerCase().equals("quinten is")) {
            System.out.println("Quint");
            System.out.println(message.getMember().getNickname());
            channel.sendMessage("Quinten is kebab").queue();
        } else if (content.toLowerCase().equals("!kebab")) {
            System.out.println(message.getMember().getNickname());
            channel.sendMessage("Kebab is Quinten.").queue();
        }
        if (content.toLowerCase().equals("jonathan is")) {
            channel.sendMessage("Jonathan is de beste docent op school!").queue();
        }
        if (content.toLowerCase().equals("owen is")) {
            channel.sendMessage(":zebra:").queue();
        }
        if (content.toLowerCase().equals("sander is")) {
            channel.sendMessage(":sleeping_accommodation:").queue();
        }
        if (content.toLowerCase().equals("dean is") && !message.getAuthor().getName().equals("Netherspite")) {
            channel.sendMessage(message.getMember().getNickname() + "You need to shut the fuck up").queue();
        }
        System.out.println("Event Registered");
    }
}