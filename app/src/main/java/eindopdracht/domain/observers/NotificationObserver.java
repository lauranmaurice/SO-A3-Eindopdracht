package eindopdracht.domain.observers;

import java.util.ArrayList;
import java.util.List;

import eindopdracht.domain.notifications.NotificationSender;

/**
 * NotificationObserver
 */
public class NotificationObserver<T> extends Observer<T> {

    private List<NotificationSender> senders;

	public NotificationObserver() {
		senders = new ArrayList<>();
	}

	public void addNotificationSender(NotificationSender sender) {
		senders.add(sender);
	}

	public void removeNotificationSender(NotificationSender sender) {
		senders.remove(sender);
	}

	@Override
	public void update(T value) {
		for (var s : senders) {
			s.send("updated: "+value.toString());
		}
	}
}