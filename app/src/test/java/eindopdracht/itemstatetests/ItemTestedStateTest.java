package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemTestedStateTest {
    
    private static BacklogComponent backlogComponent;

    @BeforeEach
    public void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getTestedState());

    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Can't move to toDo from tested.", message);
        assertEquals(backlogComponent.getTestedState(), backlogComponent.getState());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Can't move to doing from tested.", message);
        assertEquals(backlogComponent.getTestedState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTesting(){
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Moved to readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test 
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move to testing from tested.", message);
        assertEquals(backlogComponent.getTestedState(), backlogComponent.getState());
    }

    @Test
    public void moveToTested(){
        String message = backlogComponent.moveToTested();
        assertEquals("Can't move to tested from tested.", message);
        assertEquals(backlogComponent.getTestedState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Moved to done", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Can't move to closed from tested.", message);
    }
    

}
