package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemToDoStateTest {
    
    private static BacklogComponent backlogComponent;

    @BeforeEach
    public void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getToDoState());
    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Can't move to toDo from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Item moved to Doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTesting(){
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Can't move to readyForTesting from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }

    @Test
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move to testing from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }

    @Test
    public void moveToTested(){
        String message = backlogComponent.moveToTested();
        assertEquals("Can't move to tested from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Can't move to done from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Can't move to closed from toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
    }
    
}
