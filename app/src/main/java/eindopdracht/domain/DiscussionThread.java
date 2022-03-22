package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.observers.NotificationObserver;
import eindopdracht.domain.observers.Observer;
import eindopdracht.domain.observers.Subject;

public class DiscussionThread extends Subject<Comment> {

    private BacklogItem backlogItem;
    private List<Comment> comments;

    public DiscussionThread(BacklogItem backlogItem){
        this.backlogItem = backlogItem;
        comments = new ArrayList<>();
    }

    @Override
    public void register(Observer<Comment> observer) {
        this.backlogItem.getDeveloper().addMethods((NotificationObserver<Comment>)observer);
        super.register(observer);
    }

    public BacklogItem getBacklogItem(){
        return this.backlogItem;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
        this.notify(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

    public List<Comment> getComments(){
        return this.comments;
    }  
    
}
