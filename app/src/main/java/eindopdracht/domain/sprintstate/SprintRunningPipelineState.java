package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintRunningPipelineState implements SprintState{
    
    Sprint sprint;

    public SprintRunningPipelineState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        return "Can't start sprint from running pipeline state.";
    }

    @Override
    public String editSprint(String name, Integer number) {
        return "Can't edit sprint from running pipeline state.";
    }

    @Override
    public String completeSprint() {
        return "Can't complete sprint from running pipeline state.";
    }

    @Override
    public String releaseSprint() {
        return "Can't release sprint from running pipeline state.";
    }

    @Override
    public String printErrorPipeline() {
        this.sprint.setState(this.sprint.getFinishedState());
        return "There is an error with running the pipeline.";
    }

    @Override
    public String succeedPipeline() {
        this.sprint.setState(this.sprint.getClosedState());
        return "Pipeline has succeeded.";
    }

    @Override
    public String cancelRelease() {
        return "Can't cancel release from running pipeline state.";
    }

    @Override
    public String holdSprintReview() {
        return "Can't hold sprint review from running pipeline state.";
    }

    @Override
    public String uploadReview() {
        return "Can't upload review from running pipeline state.";
    }
}
