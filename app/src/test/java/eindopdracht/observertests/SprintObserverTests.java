package eindopdracht.observertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Person;
import eindopdracht.domain.ProductOwner;
import eindopdracht.domain.Project;
import eindopdracht.domain.Sprint;
import eindopdracht.domain.backlog.BacklogItem;

public class SprintObserverTests {
    private static Project project;
    private static Person master;
    private static Sprint sprint1;

    @BeforeAll
    public void setup() {
        master = TestHelper.giveMeAScrumMaster();
        project = new Project("TheCircle", master, new ProductOwner("henk", "", "po@circle.me"));
        sprint1 = new Sprint("1", 1, master);
    }


    @Test
    public void canNotifyPeopleWhenStateChanges() {
        var developer = TestHelper.giveMeADev();
        project.addPerson(developer);
        project.addSprint(sprint1);
        
        //clear inboxes
        for (var s : developer.getNotificationSenders()) {
            s.getInbox().clear();
        }

        sprint1.setState(sprint1.getStartedState());
    
        for (var s : developer.getNotificationSenders()) {
            assertEquals(1, s.getInbox().size());
        }

        //TODO: test if henk@mail.ru received email
    }

    @Test
    public void canAlsoNotifyPeopleThatAppearedLater() {
        var bas = TestHelper.giveMeADev();
        bas.setName("Bas");
        bas.setEmail("bas@bar.org");
        
        System.out.println("im here!");
        sprint1.setState(sprint1.getReviewDoneState());

        assertEquals(1, bas.getNotificationSenders().get(0).getInbox().size());
        var henk = project.getPersons().get(0);
        assertTrue(henk.getNotificationSenders().get(0).getInbox().size() >= 1);

        //TODO: test if bas and henk received email
    }

    @Test
    public void scrumMasterReceivesIfFromInTestToToDo() {
        var task = new BacklogItem(1, "Lets go", "een omschrijving");

        task.setState(task.getTestingState());
        sprint1.getBacklog().addItem(task);

        var item = sprint1.getBacklog().getItems().get(0);
        item.setState(item.getToDoState());
        //TODO: test if scrum master receives email
    }
}
