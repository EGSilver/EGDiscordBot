package discordbot;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class taakListener extends ListenerAdapter {
    private final long channelId, authorId;

    public taakListener(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // stops the bots from responding to itself.
        MessageChannel channel = event.getChannel();
        String content = event.getMessage().getContentRaw();
        if (content.equals("0")) {
            event.getJDA().removeEventListener(this); // stops listening.
        }
        if (event.getAuthor().getIdLong() == authorId && content.equals("1") || event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("java")) {
            channel.sendMessage("Welke taak van Java?").queue();
            event.getJDA().removeEventListener(this);
        } else if (event.getAuthor().getIdLong() == authorId && content.equals("2") || event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("nosql")) {
            channel.sendMessage("Welke taak van NoSQL?").queue();
            event.getJDA().removeEventListener(this);
        } else if (event.getAuthor().getIdLong() == authorId && content.equals("3") || event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("project")) {
            channel.sendMessage("Welke taak van Project?").queue();
            event.getJDA().removeEventListener(this);
        } else if (event.getAuthor().getIdLong() == authorId && content.equals("4") || event.getAuthor().getIdLong() == authorId && content.toLowerCase().contains("ui")) {
            channel.sendMessage("Welke taak van UI?").queue();
            event.getJDA().removeEventListener(this);
        } else {
            channel.sendMessage("Ok dan niet.").queue();
            event.getJDA().removeEventListener(this);

        }
    }
}
