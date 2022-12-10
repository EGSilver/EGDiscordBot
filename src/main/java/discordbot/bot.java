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

import java.time.Duration;
import java.util.Objects;


public class bot extends ListenerAdapter {
    private static final String BOT_TOKEN = "";

    public static void main(String[] arguments) throws Exception {
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
        if (content.startsWith("!taak")) {
            channel.sendMessage("Welk vak?\n1. Java\n2. NoSQL\n3. Project\n4. UI").queue();
            event.getJDA().addEventListener(new taakListener(channel, member.getUser()));
        }

        System.out.println("Event Registered");
    }
}
