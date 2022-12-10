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
        JDA api =   JDABuilder.createLight(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new bot())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equals("!ping")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue();
        }
        if (content.toLowerCase().equals("hey") || content.toLowerCase().equals("hallo")) {
            System.out.println("Welcome message");
            Message messageNaught = event.getMessage();
            String nickname = Objects.requireNonNull(messageNaught.getMember()).getNickname();
            String contentNaught = message.getContentRaw();
            MessageChannel channelNaught = event.getChannel();
            channelNaught.sendMessage("Hallo " + nickname).queue();


        }
        System.out.println("Event Registered");
    }
}
