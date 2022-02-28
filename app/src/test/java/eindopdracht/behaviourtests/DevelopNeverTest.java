package eindopdracht.behaviourtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestNever;

/**
 * DevelopNeverTest
 */
public class DevelopNeverTest {

    private static Person notDeveloper;
    
    @BeforeAll
    public static void prepare(){
    notDeveloper = new Person("Rathalos", "Rathalos@home.nl", "0678291234", new DevelopNever(), new TestNever(), new ScrumNever());

    }
    
    @Test
    public void canDevelop(){
        assertEquals(false, notDeveloper.canDevelop());
    }

    @Test
    public void Develop(){
        assertEquals("Not allowed to develop.", notDeveloper.develop());
    }
}