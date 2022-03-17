package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemClosedStateTest {
    
    private static BacklogComponent backlogComponent;
    
    @BeforeAll
    public static void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getClosedState());

    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTesting(){
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToTested(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Can't move from closed state.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }

}
