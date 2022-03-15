package eindopdracht.sprintstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Sprint;

public class SprintClosedStateTest {
    
    private static Sprint sprint;
    
    @BeforeAll
    public static void prepare(){
        sprint = new Sprint("eerste sprint", 1);
        sprint.setState(sprint.getClosedState());

    }
    
    @Test
    public void startSprint(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.startSprint());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test
    public void editSprint(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.editSprint("tweede sprint", 2));
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void completeSprint(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.completeSprint());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void releaseSprint(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.releaseSprint());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void printErrorPipeline(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.printErrorPipeline());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void succeedPipeline(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.succeedPipeline());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void cancelRelease(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.cancelRelease());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void holdSprintReview(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.holdSprintReview());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test 
    public void uploadReview(){
        assertEquals("No actions can be taken when the sprint is closed.", sprint.uploadReview());
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

}
