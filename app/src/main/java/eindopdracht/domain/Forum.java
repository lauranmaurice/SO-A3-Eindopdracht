package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Forum
 */
public class Forum {

    private List<DiscussionThread> discussions;

    public Forum(){
        discussions = new ArrayList<>();
    }
    
    public void addDiscussion(DiscussionThread discussionThread){
        this.discussions.add(discussionThread);
    }

    public void removeDiscussion(DiscussionThread discussionThread){
        this.discussions.remove(discussionThread);
    }

    public List<DiscussionThread> getDiscussions(){
        return this.discussions;
    }
    
}