package eindopdracht.observertests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Comment;
import eindopdracht.domain.DiscussionThread;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.observers.ThreadObserver;

public class ThreadObserverTests {
    
    @Test
    public void CanGetNotified() {
        var item = new BacklogItem(1, "Titel", "omschrijving");
        var person = TestHelper.giveMeADev();
        item.setDeveloper(person);
        var thread = new DiscussionThread(item);

        var to = new ThreadObserver();
        to.subscribeTo(thread);

        thread.addComment(new Comment("Wooo, java code looks like shit", TestHelper.giveMeAScrumMaster()));
        var postVakIn = person.getNotificationSenders().get(0).getInbox();
        assertEquals(1, postVakIn.size());
    }
}
