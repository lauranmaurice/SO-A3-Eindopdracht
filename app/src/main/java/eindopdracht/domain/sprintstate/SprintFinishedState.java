package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintFinishedState implements SprintState{
    
    Sprint sprint;

    public SprintFinishedState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        return "Can't start sprint from finished state.";
    }

    @Override
    public String editSprint(String name, Integer number) {
        return "Can't edit sprint from finished state.";
    }

    @Override
    public String completeSprint() {
        return "Can't complete sprint from finished state.";
    }

    @Override
    public String releaseSprint() {
        this.sprint.setState(this.sprint.getRunningPipelineState());
        return "Pipeline is running.";
    }

    @Override
    public String printErrorPipeline() {
        return "Can't print error pipeline from finished state.";
    }

    @Override
    public String succeedPipeline() {
        return "Can't succeed pipeline from finished state.";
    }

    @Override
    public String cancelRelease() {
        this.sprint.setState(this.sprint.getClosedState());
        return "Release has been cancelled.";
    }

    @Override
    public String holdSprintReview() {
        this.sprint.setState(this.sprint.getReviewDone());
        return "Review has been held.";
    }

    @Override
    public String uploadReview() {
        return "Can't upload review from finished state.";
    }
}
