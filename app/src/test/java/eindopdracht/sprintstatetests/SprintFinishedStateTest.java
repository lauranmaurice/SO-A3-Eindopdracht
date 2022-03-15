package eindopdracht.sprintstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Sprint;

public class SprintFinishedStateTest {
    
    public static Sprint sprint;

    @BeforeEach
    public void prepare(){
        sprint = new Sprint("eerste sprint", 1);
        sprint.setState(sprint.getFinishedState());

    }
    
    @Test
    public void startSprint(){
        String message = sprint.startSprint();
        assertEquals("Can't start sprint from finished state.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void editSprint(){
        String message = sprint.editSprint("2e sprint", 2);
        assertEquals("Can't edit sprint from finished state.", message);
        assertEquals("eerste sprint", sprint.getSprintName());
        assertEquals(1, sprint.getSprintNumber());
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void completeSprint(){
        String message = sprint.completeSprint();
        assertEquals("Can't complete sprint from finished state.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void releaseSprint(){
        String message = sprint.releaseSprint();
        assertEquals("Pipeline is running.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void printErrorPipeline(){
        String message = sprint.printErrorPipeline();
        assertEquals("Can't print error pipeline from finished state.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void succeedPipeline(){
        String message = sprint.succeedPipeline();
        assertEquals("Can't succeed pipeline from finished state.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void cancelRelease(){
        String message = sprint.cancelRelease();
        assertEquals("Release has been cancelled.", message);
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test
    public void holdSprintReview(){
        String message = sprint.holdSprintReview();
        assertEquals("Review has been held.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void uploadReview(){
        String message = sprint.uploadReview();
        assertEquals("Can't upload review from finished state.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

}
