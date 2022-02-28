package eindopdracht.behaviourtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestAll;

/**
 * TestAll
 */
public class TestAllTest {

    private static Person tester;
    
    @BeforeAll
    public static void prepare(){
    tester = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopNever(), new TestAll(), new ScrumNever());

    }
    
    @Test
    public void canDevelop(){
        assertEquals(true, tester.canTest());
    }

    @Test
    public void Develop(){
        assertEquals("Testing", tester.test());
    }
}