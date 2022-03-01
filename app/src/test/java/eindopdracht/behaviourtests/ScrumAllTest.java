package eindopdracht.behaviourtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.TestNever;

/**
 * ScrumAllTest
 */
public class ScrumAllTest {

    private static Person scrumMaster;
    
    @BeforeAll
    public static void prepare(){
    scrumMaster = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopNever(), new TestNever(), new ScrumAll());
    }
    
    @Test
    public void canScrum(){
        assertEquals(true, scrumMaster.canScrum());
    }

    @Test
    public void Develop(){
        assertEquals("Scrumming", scrumMaster.scrum());
    }
}