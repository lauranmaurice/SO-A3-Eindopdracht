package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintReviewDoneState implements SprintState{
    
    Sprint sprint;

    public SprintReviewDoneState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        return "Can't start sprint from review done state.";
    }

    @Override
    public String editSprint(String name, Integer number) {
        return "Can't edit sprint from review done state.";
    }

    @Override
    public String completeSprint() {
        return "Can't complete sprint from review done state.";
    }

    @Override
    public String releaseSprint() {
        return "Can't release sprint from review done state.";
    }

    @Override
    public String printErrorPipeline() {
        return "Can't print error pipeline from review done state.";
    }

    @Override
    public String succeedPipeline() {
        return "Can't succeed pipeline from review done state.";
    }

    @Override
    public String cancelRelease() {
        return  "Can't cancel release from review done state.";
    }

    @Override
    public String holdSprintReview() {
        return "Can't hold sprint review from review done state.";
    }

    @Override
    public String uploadReview() {
        this.sprint.setState(this.sprint.getClosedState());
        return "Sprint review has been uploaded.";
    }
}
