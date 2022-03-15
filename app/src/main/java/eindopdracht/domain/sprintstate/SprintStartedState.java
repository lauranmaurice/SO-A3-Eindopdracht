package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintStartedState implements SprintState{
    
    Sprint sprint;

    public SprintStartedState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        return "Can't start sprint from started state.";
    }

    @Override
    public String editSprint(String name, Integer number) {
        return "Can't edit sprint from started state.";
    }

    @Override
    public String completeSprint() {
        this.sprint.setState(this.sprint.getFinishedState());
        return "Sprint has been completed.";
    }

    @Override
    public String releaseSprint() {
        return "Can't release sprint from started state.";
    }

    @Override
    public String printErrorPipeline() {
        return "Can't print error pipeline from started state.";
    }

    @Override
    public String succeedPipeline() {
        return "Can't succeed pipeline from started state.";
    }

    @Override
    public String cancelRelease() {
        return "Can't cancel release from started state.";
    }

    @Override
    public String holdSprintReview() {
        return "Can't hold sprint review from started state.";
    }

    @Override
    public String uploadReview() {
        return "Can't upload review from started state.";
    }
}
