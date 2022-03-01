package eindopdracht.behaviourtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestNever;

/**
 * TestNeverTest
 */
public class TestNeverTest {

    private static Person noTester;
    
    @BeforeAll
    public static void prepare(){
    noTester = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopNever(), new TestNever(), new ScrumNever());
    }
    
    @Test
    public void canDevelop(){
        assertEquals(false, noTester.canTest());
    }

    @Test
    public void Develop(){
        assertEquals("I am not allowed to test.", noTester.test());
    }
}