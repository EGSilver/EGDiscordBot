package discordbot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UITask extends ListenerAdapter {
    private final long channelId, authorId;

    public UITask(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // stops the bots from responding to itself.
        DirectoryInfo scan = new DirectoryInfo();
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        Member member = message.getMember();
        String content = event.getMessage().getContentRaw();
    }
}
