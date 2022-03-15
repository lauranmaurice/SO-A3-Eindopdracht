package eindopdracht.domain.sprintstate;

import eindopdracht.domain.Sprint;

public class SprintCreatedState implements SprintState{
    
    Sprint sprint;

    public SprintCreatedState(Sprint sprint){
        this.sprint = sprint;
    }

    @Override
    public String startSprint() {
        this.sprint.setState(sprint.getStartedState());
        return "Sprint started.";
    }

    @Override
    public String editSprint(String name, Integer sprintNumber) {
        if (name != null){
            this.sprint.setSprintName(name);
        }
        if (sprintNumber != null){
            this.sprint.setSprintNumber(sprintNumber);
        }
        return "Sprint edited.";
    }

    @Override
    public String completeSprint() {
        return "Can't complete sprint from created state.";
    }

    @Override
    public String releaseSprint() {
        return "Can't release sprint from created state.";
    }

    @Override
    public String printErrorPipeline() {
        return "Can't print error pipeline from created state.";
    }

    @Override
    public String succeedPipeline() {
        return "Can't succeed pipeline from created state.";
    }

    @Override
    public String cancelRelease() {
        return "Can't cancel release from created state.";
    }

    @Override
    public String holdSprintReview() {
        return "Can't hold sprint review from created state.";
    }

    @Override
    public String uploadReview() {
        return "Can't upload review from created state.";
    }
}
