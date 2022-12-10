package discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
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

        if (content.toLowerCase().contains("hi") || content.toLowerCase().contains("hello") || content.toLowerCase().contains("hey")) {
            System.out.println("Welcome message");
            System.out.println(message.getMember().getNickname());
            channel.sendMessage("Hallo " + nickname).queue();
        }

        if (content.toLowerCase().contains("fuck") || content.toLowerCase().contains("shit")) {
            message.getMember().timeoutFor(Duration.ofSeconds(30)).queue();
            channel.sendMessage(message.getMember().getEffectiveName() + " You said the word " + message + " You have been timed out for " + thirtySeconds).queue();
        }

        System.out.println("Event Registered");
    }
}
