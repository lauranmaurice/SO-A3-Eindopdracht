package eindopdracht.rapporttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.ProductOwner;
import eindopdracht.domain.Project;
import eindopdracht.domain.Sprint;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.TestNever;
import eindopdracht.domain.rapport.InternRapportGenerator;
import eindopdracht.domain.rapport.RapportTemplate;

public class rapportTemplateTest {

    private static RapportTemplate rapportTemplate;
    private static BacklogItem backlogItemOne;
    private static BacklogItem backlogItemTwo;
    private static Sprint sprintOne;
    private static Sprint sprintTwo;


    @BeforeEach
    public void prepare(){
        Person scrumMaster = new Person("Velocidrome", "velocidrome@gmail.com", "0620483201", new DevelopNever(), new TestNever(), new ScrumAll());
        ProductOwner productOwner = new ProductOwner("Velociraptor", "0682301243", "raptor@gmail.com");
        
        backlogItemOne = new BacklogItem(1, "Stir soup.", "Stirring soup.");
        backlogItemOne.setState(backlogItemOne.getDoneState());
        backlogItemTwo = new BacklogItem(2, "Cook soup.", "Cooking soup.");

        sprintOne = new Sprint("onion soup", 1, scrumMaster);
        sprintOne.getBacklog().addItem(backlogItemOne);
        sprintOne.getBacklog().addItem(backlogItemTwo);
        sprintTwo = new Sprint("Champignon soup", 2, scrumMaster);

        Project project = new Project("Soup", scrumMaster, productOwner);
        project.addSprint(sprintOne);
        project.addSprint(sprintTwo);
        
        rapportTemplate = new InternRapportGenerator(project);

    }

    @Test 
    public void getSprint(){
        assertEquals(sprintOne, rapportTemplate.getSprint());
    }
    
    @Test
    public void setSprint(){
        rapportTemplate.setSprint(2);
        assertEquals(sprintTwo, rapportTemplate.getSprint());
    }

    @Test
    public void getHeader(){
        assertEquals("==Soup==   www.ourimageurl.com", rapportTemplate.getHeader());
    }

    @Test
    public void setHeader(){
        String newHeader = "salads";
        String newUrl = "www.saladsimageurl.com";
        rapportTemplate.setHeader(newHeader, newUrl);
        assertEquals("==" + newHeader + "==   " + newUrl, rapportTemplate.getHeader());
    }

    @Test
    public void getFooter(){
        assertEquals("", rapportTemplate.getFooter());
    }

    @Test
    public void setFooter(){
        String newFooter = "eind pagina";
        rapportTemplate.setFooter(newFooter);
        assertEquals(newFooter, rapportTemplate.getFooter());
    }

    @Test
    public void getTasks(){
        String expected = "========================= \n Tasks finished \n ==================== \n" +
        backlogItemOne.toString() + "\n" +
        "====================== \n Tasks not finished \n ================== \n" + 
        backlogItemTwo.toString() + "\n";
        assertEquals(expected, rapportTemplate.getTasks());
    }

    @Test
    public void getProductOwner(){
        String expected = "Product Owner: Velociraptor";
        assertEquals(expected, rapportTemplate.getProductOwner());
    }

    @Test
    public void getScrumMaster(){
        String expected = "Scrum Master: Velocidrome";
        assertEquals(expected, rapportTemplate.getScrumMaster());
    }
    
}
