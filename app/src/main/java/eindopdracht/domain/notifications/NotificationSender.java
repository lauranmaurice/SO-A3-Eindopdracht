package eindopdracht.domain.notifications;

import java.util.List;

/**
 * NotificationSender
 */
public interface NotificationSender {
    public List<String> getInbox();
    public void send(String message);
}