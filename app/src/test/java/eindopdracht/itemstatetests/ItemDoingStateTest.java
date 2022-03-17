package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemDoingStateTest {
    
    private static BacklogComponent backlogComponent;

    @BeforeEach
    public void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getDoingState());

    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Can't move to toDo from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Can't move to doing from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTestingTrue(){
        backlogComponent.setCompleted(true);
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Moved to readyForTesting.", message);
        assertEquals(backlogComponent.getReadyForTestingState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTestingFalse(){
        backlogComponent.setCompleted(false);
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Is not completed yet.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move to testing from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToTested(){
        String message = backlogComponent.moveToTested();
        assertEquals("Can't move to tested from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Can't move to done from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Can't move to closed from doing.", message);
        assertEquals(backlogComponent.getDoingState(), backlogComponent.getState());
    }

}
