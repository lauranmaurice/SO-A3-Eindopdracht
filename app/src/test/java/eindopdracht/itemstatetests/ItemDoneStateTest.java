package eindopdracht.itemstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.backlog.BacklogComponent;
import eindopdracht.domain.backlog.BacklogItem;

public class ItemDoneStateTest {
    
    private static BacklogComponent backlogComponent;

    @BeforeEach
    public void prepare(){
        backlogComponent = new BacklogItem(1, "Test Item State", "Test de item states.");
        backlogComponent.setState(backlogComponent.getDoneState());

    }
    
    @Test
    public void moveToToDo(){
        String message = backlogComponent.moveToToDo();
        assertEquals("Moved to toDo.", message);
        assertEquals(backlogComponent.getToDoState(), backlogComponent.getState());
        assertEquals(false, backlogComponent.isCompleted());
    }

    @Test
    public void moveToDoing(){
        String message = backlogComponent.moveToDoing();
        assertEquals("Can't move to doing from done.", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToReadyForTesting(){
        String message = backlogComponent.moveToReadyForTesting();
        assertEquals("Can't move to readyForTesting from done.", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToTesting(){
        String message = backlogComponent.moveToTesting();
        assertEquals("Can't move to testing from done.", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToTested(){
        String message = backlogComponent.moveToTested();
        assertEquals("Can't move to tested from done.", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToDone(){
        String message = backlogComponent.moveToDone();
        assertEquals("Can't move to done from done.", message);
        assertEquals(backlogComponent.getDoneState(), backlogComponent.getState());
    }

    @Test
    public void moveToClosed(){
        String message = backlogComponent.moveToClosed();
        assertEquals("Moved to closed.", message);
        assertEquals(backlogComponent.getClosedState(), backlogComponent.getState());
    }



    
}
