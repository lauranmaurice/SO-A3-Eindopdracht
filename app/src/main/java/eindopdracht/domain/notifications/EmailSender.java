package eindopdracht.domain.notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * EmailSender
 */
public class EmailSender implements NotificationSender {
    private String email;
    private List<String> inbox;

    public EmailSender(String email) {
        this.email = email;
        this.inbox = new ArrayList<>();
    }

    @Override
    public void send(String message) {
        System.out.println("Sending email to "+this.email+", message: "+message);
        this.inbox.add(message);
    }

    @Override
    public List<String> getInbox() {
        return this.inbox;
    }
}