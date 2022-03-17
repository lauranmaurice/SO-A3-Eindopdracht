package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemReadyForTestingStateTest {
    
    private static BacklogComponent backlogComponent;

    @BeforeEach
    public void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getReadyForTestingState());

    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Can't move to toDo from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Can't move to Doing from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTesting(){
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Can't move to readyForTesting from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Moved to testing.", message);
        assertEquals(backlogComponent.getTestingState(), backlogComponent.getState());
    }

    @Test
    public void movedToTested(){
        String message = backlogComponent.moveToTested();
        assertEquals("Can't move to tested from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Can't move to Done from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Can't move to closed from readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

}
