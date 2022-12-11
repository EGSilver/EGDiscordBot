package discordbot;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TaskListener extends ListenerAdapter {
    private final long channelId, authorId;

    public TaskListener(MessageChannel channel, User author) {
        this.channelId = channel.getIdLong();
        this.authorId = author.getIdLong();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) throws IllegalArgumentException {
        //TODO
        if (event.getAuthor().isBot()) return; // stops the bots from responding to itself.
        DirectoryInfo scan = new DirectoryInfo();
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        Member member = message.getMember();
        String content = event.getMessage().getContentRaw();
        String filesInDir = "";
        if (content.equals("0")) {
            event.getJDA().removeEventListener(this); // stops listening.
        }
        if (content.startsWith("1") || content.startsWith("!java")) {
            channel.sendMessage("Hier is een lijst met alle bekende oplossingen voor Java").queue();
            scan.readDirectory(event);
            event.getJDA().addEventListener(new JavaTask(channel, member.getUser()));
            event.getJDA().removeEventListener(this);
        } else if (content.startsWith("2") || content.startsWith("!nosql")) {
            channel.sendMessage("Hier is een lijst met alle bekende oplossingen voor NoSQL?").queue();
            event.getJDA().removeEventListener(this);
        } else if (content.startsWith("3") || content.startsWith("!project")) {
            channel.sendMessage("Hier is een lijst met alle bekende oplossingen voor Project?").queue();
            event.getJDA().removeEventListener(this);
        } else if (content.startsWith("4") || content.startsWith("!ui")) {
            channel.sendMessage("Hier is een lijst met alle bekende oplossingen voor UI?").queue();
            event.getJDA().removeEventListener(this);
        } else {
            System.out.println("taakListener end");
            event.getJDA().removeEventListener(this);
        }
    }
}


