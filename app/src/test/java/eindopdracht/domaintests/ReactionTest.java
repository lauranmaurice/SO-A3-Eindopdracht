package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.Reaction;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestAll;

public class ReactionTest {
    
    private static Reaction reaction;
    private static Person person;
    
    @BeforeEach
    public void prepare(){
        person = new Person("Shamos", "shamos@home.nl", "0688372204", new DevelopNever(), new TestAll(), new ScrumNever());
        reaction = new Reaction("<3", person);
    }
    
    @Test
    public void getSymbol(){
        assertEquals("<3", reaction.getSymbol());
    }

    @Test
    public void setSymbol(){
        reaction.setSymbol("...");
        assertEquals("...", reaction.getSymbol());
    }

    @Test
    public void getPerson(){
        assertEquals(person, reaction.getPerson());
    }
}
