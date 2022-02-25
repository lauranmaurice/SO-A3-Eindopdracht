package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    
    private String text;
    private Person person;
    private List<Reaction> reactions;
    private List<Comment> comments;

    public Comment(String text, Person person){
        setText(text);
        this.person = person;
        reactions = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getPerson(){
        return this.person;
    }

    public void addReaction(Reaction reaction){
        this.reactions.add(reaction);
    }

    public void removeReaction(Reaction reaction){
        this.reactions.remove(reaction);
    }

    public List<Reaction> getReactions(){
        return this.reactions;
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
