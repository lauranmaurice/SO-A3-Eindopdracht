package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Comment;
import eindopdracht.domain.Person;
import eindopdracht.domain.Reaction;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestAll;

public class CommentTest {
    
    private static Comment comment;
    private static Person person;
    private static Person reactor;
    
    @BeforeEach
    public void prepare(){
        person = new Person("Girros", "girros@home.nl", "0622384495", new DevelopAll(), new TestAll(), new ScrumAll());
        comment = new Comment("Ik wil gewoon even mijn mening geven.", person);
        reactor = new Person("Shamos", "shamos@home.nl", "0688372204", new DevelopNever(), new TestAll(), new ScrumNever());
    }
    
    @Test
    public void getText(){
        assertEquals("Ik wil gewoon even mijn mening geven.", comment.getText());
    }

    @Test
    public void setText(){
        comment.setText("Mijn mening is veranderd.");
        assertEquals("Mijn mening is veranderd.", comment.getText());
    }

    @Test
    public void getPerson(){
        assertEquals(person, comment.getPerson());
    }

    @Test
    public void addReaction(){
        Reaction reaction = new Reaction("<3", reactor);
        comment.addReaction(reaction);
        assertEquals(reaction, comment.getReactions().get(0));
    }

    @Test
    public void removeReaction(){
        Reaction reaction = new Reaction("<3", reactor);
        comment.addReaction(reaction);
        comment.removeReaction(reaction);
        assertEquals(0, comment.getReactions().size());
    }

    @Test
    public void addComment(){
        Comment reactComment = new Comment("Had iemand wel om jouw mening gevraagd?", reactor);
        comment.addComment(reactComment);
        assertEquals(reactComment, comment.getComments().get(0));
    }

    @Test
    public void removeComment(){
        Comment reactComment = new Comment("Had iemand wel om jouw mening gevraagd?", reactor);
        comment.addComment(reactComment);
        comment.removeComment(reactComment);
        assertEquals(0, comment.getComments().size());
    }

}
