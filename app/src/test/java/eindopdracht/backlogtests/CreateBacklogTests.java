package eindopdracht.backlogtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.Backlog;
import eindopdracht.domain.backlog.BacklogItem;
import eindopdracht.domain.backlog.BacklogTask;
import eindopdracht.domain.backlog.Epic;
import eindopdracht.domain.observers.TaskObserver;

/**
 * CreateBacklogTests
 */
public class CreateBacklogTests {
    private Backlog testBacklog;

    @BeforeEach
    public void prepareBacklog() {
        this.testBacklog = new Backlog(new TaskObserver());
        
        var e1 = new Epic(1, "Epic 1", "What should we say?");
        var e2 = new Epic(2, "Epic 2", "He walked down the river");

        var i1 = new BacklogItem(3, "Item I", "But why did you not look for the steps?");
        var i2 = new BacklogItem(4, "Item II", "Truly, I did not know");
        var i3 = new BacklogItem(5, "Item III", "Now that is another item");

        var t1 = new BacklogTask(1, "Task 1", "Another task");
        var t2 = new BacklogTask(1, "Task 2", "YEAT: Yet Another Amazing Task");

        t1.setCompleted(true);
        t2.setCompleted(true);

        //i3.setCompleted(true); //not needed, addItem sets the completed state

        i3.addItem(t1);
        i3.addItem(t2);

        e2.addItem(i3);

        this.testBacklog.addItem(e1);
        this.testBacklog.addItem(e2);
        this.testBacklog.addItem(i1);
        this.testBacklog.addItem(i2);
    }
    
    @Test
    public void canCreateBacklogWithEpicsAndItems() {
        var backlog = new Backlog(new TaskObserver());

        var epic = new Epic(1, "AnEpic", "It's Epic!");
        var item = new BacklogItem(1, "Item", "Just an item");

        backlog.addItem(epic);
        backlog.addItem(item);

        assertEquals(2, backlog.getItems().size());

        assertEquals("AnEpic", backlog.getItems().get(0).getTitle());
        assertEquals("eindopdracht.domain.backlog.Epic", backlog.getItems().get(0).getClass().getName());
        assertEquals("Item", backlog.getItems().get(1).getTitle());
        assertEquals("eindopdracht.domain.backlog.BacklogItem", backlog.getItems().get(1).getClass().getName());
    }

    @Test
    public void canFilterEpics() {
        var backlog = this.testBacklog;
        assertEquals(4, backlog.getItems().size());

        assertEquals(2, backlog.getEpics().size());
        assertEquals("Epic 1", backlog.getEpics().get(0).getTitle());
    }

    @Test
    public void canFilterItems() {
        var backlog = this.testBacklog;
        assertEquals(4, backlog.getItems().size());

        assertEquals(2, backlog.getBacklogItems().size());
        assertEquals("Item I", backlog.getBacklogItems().get(0).getTitle());
    }

    @Test
    public void canCheckCompleted() {
        var epic = this.testBacklog.getEpics().get(1);
        assertEquals("Epic 2", epic.getTitle());

        assertEquals(true, epic.isCompleted());
    }

    @Test
    public void epicShoudNotBeCompletedIfOneTaskIsNot() {
        var epic = this.testBacklog.getEpics().get(1);
        assertEquals("Epic 2", epic.getTitle());

        epic.getItems().get(0).getItems().get(0).setCompleted(false);

        assertEquals(false, epic.isCompleted());
    }
}