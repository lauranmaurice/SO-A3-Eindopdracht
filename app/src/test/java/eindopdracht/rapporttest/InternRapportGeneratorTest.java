package eindopdracht.rapporttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Person;
import eindopdracht.domain.ProductOwner;
import eindopdracht.domain.Project;
import eindopdracht.domain.Sprint;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestAll;
import eindopdracht.domain.behaviour.TestNever;
import eindopdracht.domain.rapport.InternRapportGenerator;
import eindopdracht.domain.rapport.RapportTemplate;

public class InternRapportGeneratorTest {
    private static RapportTemplate rapportTemplate;
    private static BacklogItem backlogItemOne;
    private static BacklogItem backlogItemTwo;
    private static Sprint sprintOne;
    private static Sprint sprintTwo;
    private static Person teamDeveloper;
    private static Person teamTester;


    @BeforeEach
    public void prepare(){
        Person scrumMaster = new Person("Velocidrome", "velocidrome@gmail.com", "0620483201", new DevelopNever(), new TestNever(), new ScrumAll());
        ProductOwner productOwner = new ProductOwner("Velociraptor", "0682301243", "raptor@gmail.com");
        teamDeveloper = new Person("Gendrome", "gendrome@gmail.com", "0638282383", new DevelopAll(), new TestNever(), new ScrumNever());
        teamTester = new Person("Iodrome", "iodrome@gmail.com", "0632403394", new DevelopNever(), new TestAll(), new ScrumNever());
        
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
        project.addPerson(teamDeveloper);
        project.addPerson(teamTester);
        
        rapportTemplate = new InternRapportGenerator(project);

    }

    @Test 
    public void teamComposition(){
        String expected = "Team members: \n" 
        + teamDeveloper.getName() + "\n" 
        + teamTester.getName() + "\n";
        assertEquals(expected, rapportTemplate.teamComposition());
    }

    @Test
    public void run(){
        String expected = "==Soup==   www.ourimageurl.com\n" + 
        "Product Owner: Velociraptor\n" +
        "Scrum Master: Velocidrome\n" +
        "Team members: \n" 
        + teamDeveloper.getName() + "\n" 
        + teamTester.getName() + "\n" +
        "========================= \n Tasks finished \n ==================== \n" +
        backlogItemOne.toString() + "\n" +
        "====================== \n Tasks not finished \n ================== \n" + 
        backlogItemTwo.toString() + "\n" +
        "";
        assertEquals(expected, rapportTemplate.run());
    }
}
