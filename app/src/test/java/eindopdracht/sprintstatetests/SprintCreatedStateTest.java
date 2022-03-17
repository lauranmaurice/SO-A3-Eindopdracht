package eindopdracht.sprintstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Sprint;

public class SprintCreatedStateTest {
    
    private static Sprint sprint;
    
    @BeforeEach
    public void prepare(){
        sprint = new Sprint("eerste sprint", 1, TestHelper.giveMeAScrumMaster());
        sprint.setState(sprint.getCreatedState());

    }
    
    @Test
    public void startSprint(){
        String message = sprint.startSprint();
        assertEquals("Sprint started.", message);
        assertEquals(sprint.getStartedState(), sprint.getState());
    }

    @Test
    public void editSprint(){
        String message = sprint.editSprint("2e sprint", 2);
        assertEquals("Sprint edited.", message);
        assertEquals("2e sprint", sprint.getSprintName());
        assertEquals(2, sprint.getSprintNumber());
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void completeSprint(){
        String message = sprint.completeSprint();
        assertEquals("Can't complete sprint from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    } 

    @Test
    public void releaseSprint(){
        String message = sprint.releaseSprint();
        assertEquals("Can't release sprint from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void printErrorPipeline(){
        String message = sprint.printErrorPipeline();
        assertEquals("Can't print error pipeline from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void succeedPipeline(){
        String message = sprint.succeedPipeline();
        assertEquals("Can't succeed pipeline from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void cancelRelease(){
        String message = sprint.cancelRelease();
        assertEquals("Can't cancel release from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void holdSprintReview(){
        String message = sprint.holdSprintReview();
        assertEquals("Can't hold sprint review from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }

    @Test
    public void uploadReview(){
        String message = sprint.uploadReview();
        assertEquals("Can't upload review from created state.", message);
        assertEquals(sprint.getCreatedState(), sprint.getState());
    }
}
