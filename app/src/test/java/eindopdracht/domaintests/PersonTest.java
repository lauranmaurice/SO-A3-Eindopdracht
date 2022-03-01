package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestAll;
import eindopdracht.domain.behaviour.TestNever;

public class PersonTest {
    
    private static Person person;
    
    @BeforeEach
    public void prepare(){
        person = new Person("Kommo-o", "kommo@home.nl", "0683912274", new DevelopAll(), new TestAll(), new ScrumAll());
    }
    
    @Test
    public void setDeveloperBehaviour(){
        person.setDeveloperBehaviour(new DevelopNever());
        assertEquals(false, person.canDevelop());
    }

    @Test
    public void setTesterBehaviour(){
        person.setTesterBehaviour(new TestNever());
        assertEquals(false, person.canTest());
    }

    @Test
    public void setScrumMasterBehaviour(){
        person.setScrumMasterBehaviour(new ScrumNever());
        assertEquals(false, person.canScrum());
    }

    @Test
    public void getPhonenumber(){
        assertEquals("0683912274", person.getPhonenumber());
    }

    @Test
    public void setPhonenumber(){
        person.setPhonenumber("0683292245");
        assertEquals("0683292245", person.getPhonenumber());
    }

    @Test
    public void getEmail(){
        assertEquals("kommo@home.nl", person.getEmail());
    }

    @Test 
    public void setEmail(){
        person.setEmail("kommo-o@home.nl");
        assertEquals("kommo-o@home.nl", person.getEmail());
    }

    @Test
    public void getName(){
        assertEquals("Kommo-o", person.getName());
    }

    @Test
    public void setName(){
        person.setName("Hakommo-o");
        assertEquals("Hakommo-o", person.getName());
    }
    
}
