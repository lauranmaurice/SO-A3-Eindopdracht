package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class DiscussionThread {

    private BacklogItem backlogItem;
    private List<Comment> comments;

    public DiscussionThread(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
        comments = new ArrayList<>();
    }

    public BacklogItem getBacklogItem(){
        return this.backlogItem;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

    public List<Comment> getComments(){
        return this.comments;
    }  
    
}
