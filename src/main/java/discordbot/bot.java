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
    private static final String BOT_TOKEN = "MTA1MTE1NzQ5ODE4MDE0MTE0Ng.G8C0GU.Jex3MzJX11xi0eXVbjaRL7_UGjly83IvWNPBNo";

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
        if (content.toLowerCase().equals("hey")) {
            System.out.println("Not nice");
            Message messageNaught = event.getMessage();
            String contentNaught = message.getContentRaw();
            MessageChannel channelNaught = event.getChannel();
            channelNaught.sendMessage(Objects.requireNonNull(messageNaught.getMember()).getNickname() + " Hallo!").queue();


        }
        System.out.println("Event Registered");
    }
}
