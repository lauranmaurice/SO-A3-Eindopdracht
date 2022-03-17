package eindopdracht.sprintstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.TestHelper;
import eindopdracht.domain.Sprint;

public class SprintRunningPipelineStateTest {
    
    public static Sprint sprint;

    @BeforeEach
    public void prepare(){
        sprint = new Sprint("eerste sprint", 1, TestHelper.giveMeAScrumMaster());
        sprint.setState(sprint.getRunningPipelineState());

    }
    
    @Test
    public void startSprint(){
        String message = sprint.startSprint();
        assertEquals("Can't start sprint from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void editSprint(){
        String message = sprint.editSprint("2e sprint", 2);
        assertEquals("Can't edit sprint from running pipeline state.", message);
        assertEquals("eerste sprint", sprint.getSprintName());
        assertEquals(1, sprint.getSprintNumber());
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void completeSprint(){
        String message = sprint.completeSprint();
        assertEquals("Can't complete sprint from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void releaseSprint(){
        String message = sprint.releaseSprint();
        assertEquals("Can't release sprint from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void printErrorPipeline(){
        String message = sprint.printErrorPipeline();
        assertEquals("There is an error with running the pipeline.", message);
        assertEquals(sprint.getFinishedState(), sprint.getState());
    }

    @Test
    public void succeedPipeline(){
        String message = sprint.succeedPipeline();
        assertEquals("Pipeline has succeeded.", message);
        assertEquals(sprint.getClosedState(), sprint.getState());
    }

    @Test
    public void cancelRelease(){
        String message = sprint.cancelRelease();
        assertEquals("Can't cancel release from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void holdSprintReview(){
        String message = sprint.holdSprintReview();
        assertEquals("Can't hold sprint review from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }

    @Test
    public void uploadReview(){
        String message = sprint.uploadReview();
        assertEquals("Can't upload review from running pipeline state.", message);
        assertEquals(sprint.getRunningPipelineState(), sprint.getState());
    }
}
