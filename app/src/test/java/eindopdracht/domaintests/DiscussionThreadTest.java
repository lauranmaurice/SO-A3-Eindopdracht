package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Comment;
import eindopdracht.domain.DiscussionThread;
import eindopdracht.domain.Person;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.TestAll;

public class DiscussionThreadTest {
    
    private static BacklogItem backlogItem;
    private static DiscussionThread discussionThread;
    
    @BeforeEach
    public  void prepare(){
        backlogItem = new BacklogItem(1, "Catch monsters", "The most ethical way of cathing is still unclear.");
        discussionThread = new DiscussionThread(backlogItem);

    }
    
    @Test
    public void getBacklogItem(){
        assertEquals(backlogItem, discussionThread.getBacklogItem());
    }

    @Test
    public void addComment(){
        Person person = new Person("Garchomp", "garchomp@home.nl", "0683923491", new DevelopAll(), new TestAll(), new ScrumAll());
        Comment comment = new Comment("We should use a pitfall trap!", person);

        discussionThread.addComment(comment);
        assertEquals(comment, discussionThread.getComments().get(0));
    }

    @Test
    public void removeComment(){
        Person person = new Person("Garchomp", "garchomp@home.nl", "0683923491", new DevelopAll(), new TestAll(), new ScrumAll());
        Comment comment = new Comment("We should use a pitfall trap!", person);

        discussionThread.addComment(comment);
        discussionThread.removeComment(comment);

        assertEquals(0, discussionThread.getComments().size());
    }

}
