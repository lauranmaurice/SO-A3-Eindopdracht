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
    public static void setup() {
        master = TestHelper.giveMeAScrumMaster();
        project = new Project("TheCircle", master, new ProductOwner("henk", "", "po@circle.me"));
        sprint1 = new Sprint("1", 1, master);
        var developer = TestHelper.giveMeADev();
        project.addPerson(developer);
        project.addSprint(sprint1);
    }


    @Test
    public void canNotifyPeopleWhenStateChanges() {
        var developer = project.getPersons().get(0);        
        //clear inboxes
        for (var s : developer.getNotificationSenders()) {
            System.out.println("Clearing sender");
            s.getInbox().clear();
        }

        sprint1.setState(sprint1.getStartedState());
    
        for (var s : developer.getNotificationSenders()) {
            assertEquals(1, s.getInbox().size());
            System.out.println("inbox:"+s.getInbox().get(0));
        }
    }

    @Test
    public void canAlsoNotifyPeopleThatAppearedLater() {
        var bas = TestHelper.giveMeADev();
        bas.setName("Bas");
        bas.setEmail("bas@bar.org");

        project.addPerson(bas);
        
        sprint1.setState(sprint1.getReviewDoneState());

        assertEquals(1, bas.getNotificationSenders().get(0).getInbox().size());
        var henk = project.getPersons().get(0);
        assertTrue(henk.getNotificationSenders().get(0).getInbox().size() >= 1);
    }

    @Test
    public void scrumMasterReceivesIfFromInTestToToDo() {
        var task = new BacklogItem(1, "Lets go", "een omschrijving");

        task.setState(task.getTestingState());
        sprint1.getBacklog().addItem(task);

        var item = sprint1.getBacklog().getItems().get(0);
        item.setState(item.getToDoState());

        assertEquals(1, master.getNotificationSenders().get(0).getInbox().size());
    }
}
