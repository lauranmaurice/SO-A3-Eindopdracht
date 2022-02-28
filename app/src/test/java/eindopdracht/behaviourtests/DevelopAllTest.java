package eindopdracht.behaviourtests;

import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestNever;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

/**
 * DevelopAllTest
 */

public class DevelopAllTest {


    private static Person developer;
    
    @BeforeAll
    public static void prepare(){
        developer = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopAll(), new TestNever(), new ScrumNever());

    }
    
    @Test
    public void canDevelop(){
        assertEquals(true, developer.canDevelop());
    }

    @Test
    public void Develop(){
        assertEquals("Developing.", developer.develop());
    }
    
}