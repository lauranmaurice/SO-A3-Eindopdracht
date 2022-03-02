package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintClosedState implements SprintState{
    
    Sprint sprint;

    public SprintClosedState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String editSprint(String name, Integer number) {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String completeSprint() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String releaseSprint() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String printErrorPipeline() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String succeedPipeline() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String cancelRelease() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String holdSprintReview() {
        return "No actions can be taken when the sprint is closed.";
    }

    @Override
    public String uploadReview() {
        return "No actions can be taken when the sprint is closed.";
    }
}
