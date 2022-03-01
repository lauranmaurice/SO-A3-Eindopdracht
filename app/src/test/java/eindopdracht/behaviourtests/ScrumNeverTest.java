package eindopdracht.behaviourtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestNever;

/**
 * ScrumNeverTest
 */
public class ScrumNeverTest {

    private static Person scrumMaster;
    
    @BeforeAll
    public static void prepare(){
    scrumMaster = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopNever(), new TestNever(), new ScrumNever());
    }
    
    @Test
    public void canScrum(){
        assertEquals(false, scrumMaster.canScrum());
    }

    @Test
    public void Develop(){
        assertEquals("Can't scrum.", scrumMaster.scrum());
    }
}