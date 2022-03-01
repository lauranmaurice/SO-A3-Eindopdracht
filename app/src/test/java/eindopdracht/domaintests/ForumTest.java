package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.DiscussionThread;
import eindopdracht.domain.Forum;
import eindopdracht.domain.backlog.BacklogItem;

public class ForumTest {
    
    private static Forum forum;
    
    @BeforeEach
    public void prepare(){
        forum = new Forum();

    }
    
    @Test
    public void addDiscussion(){
        BacklogItem backlogItem = new BacklogItem(1, "Cut trees", "There's a lot of discussion about cutting trees.");
        DiscussionThread discussionThread = new DiscussionThread(backlogItem);
        
        forum.addDiscussion(discussionThread);
        assertEquals(discussionThread, forum.getDiscussions().get(0));
    }

    @Test
    public void removeDiscussion(){
        BacklogItem backlogItem = new BacklogItem(1, "Cut trees", "There's a lot of discussion about cutting trees.");
        DiscussionThread discussionThread = new DiscussionThread(backlogItem);

        forum.addDiscussion(discussionThread);
        forum.removeDiscussion(discussionThread);
        assertEquals(0, forum.getDiscussions().size());
    }
}
