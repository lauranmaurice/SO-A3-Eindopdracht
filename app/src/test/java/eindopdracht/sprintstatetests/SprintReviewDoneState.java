package eindopdracht.sprintstatetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eindopdracht.domain.Sprint;

public class SprintReviewDoneState {
    
    public static Sprint sprint;

    @BeforeEach
    public void prepare(){
        sprint = new Sprint("eerste sprint", 1);
        sprint.setState(sprint.getReviewDoneState());

    }
    
    @Test
    public void startSprint(){
        String message = sprint.startSprint();
        assertEquals("Can't start sprint from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void editSprint(){
        String message = sprint.editSprint("2e sprint", 2);
        assertEquals("Can't edit sprint from review done state.", message);
        assertEquals("eerste sprint", sprint.getSprintName());
        assertEquals(1, sprint.getSprintNumber());
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void completeSprint(){
        String message = sprint.completeSprint();
        assertEquals("Can't complete sprint from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void releaseSprint(){
        String message = sprint.releaseSprint();
        assertEquals("Can't release sprint from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void printErrorPipeline(){
        String message = sprint.printErrorPipeline();
        assertEquals("Can't print error pipeline from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void succeedPipeline(){
        String message = sprint.succeedPipeline();
        assertEquals("Can't succeed pipeline from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void cancelRelease(){
        String message = sprint.cancelRelease();
        assertEquals("Can't cancel release from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void holdSprintReview(){
        String message = sprint.holdSprintReview();
        assertEquals("Can't hold sprint review from review done state.", message);
        assertEquals(sprint.getReviewDoneState(), sprint.getState());
    }

    @Test
    public void uploadReview(){
        String message = sprint.uploadReview();
        assertEquals("Sprint review has been uploaded.", message);
        assertEquals(sprint.getClosedState(), sprint.getState());
    }
}
