package eindopdracht.domaintests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Person;
import eindopdracht.domain.ProductOwner;
import eindopdracht.domain.Project;
import eindopdracht.domain.Sprint;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.TestAll;

/**
 * ProjectTest
 */
public class ProjectTest {

    private static Project project;
    private static ProductOwner productOwner;
    private static Person scrumMaster;
    
    @BeforeAll
    public static void prepare(){
        scrumMaster = TestHelper.giveMeAScrumMaster();
        productOwner = new ProductOwner("Tobi", "0682123143", "Tobi@home.nl");
        project = new Project("Shampoo", scrumMaster, productOwner);

    }
    
    @Test
    public void getName(){
        assertEquals("Shampoo", project.getName());
    }

    @Test
    public void setName(){
        project.setName("Soap");
        assertEquals("Soap", project.getName());
    }

    @Test
    public void addSprint(){
        Sprint sprint = new Sprint("Sprint 1", 1, scrumMaster);
        project.addSprint(sprint);
        assertEquals(sprint, project.getSprints().get(0));
    }

    @Test
    public void removeSprint(){
        Sprint sprint = new Sprint("Sprint 1", 1, scrumMaster);
        project.addSprint(sprint);
        project.removeSprint(sprint);
        assertEquals(0, project.getSprints().size());

    }

    @Test
    public void getProductOwner(){
        assertEquals(productOwner, project.getProductOwner());
    }

    @Test 
    public void setProductOwner(){
        ProductOwner newProductOwner = new ProductOwner("Anjanath", "0634189321", "anjanath@home.nl");
        project.setProductOwner(newProductOwner);
        assertEquals(newProductOwner, project.getProductOwner());
    }

    @Test 
    public void addPerson(){
        Person person = new Person("Jagras", "jagras@home.nl", "06040023404", new DevelopAll(), new TestAll(), new ScrumAll());
        project.addPerson(person);
        assertEquals(person, project.getPersons().get(0));
    }

    @Test
    public void removePerson(){
        Person person = new Person("Jagras", "jagras@home.nl", "06040023404", new DevelopAll(), new TestAll(), new ScrumAll());
        project.addPerson(person);
        project.removePerson(person);
        assertEquals(0, project.getPersons().size());
    }



}