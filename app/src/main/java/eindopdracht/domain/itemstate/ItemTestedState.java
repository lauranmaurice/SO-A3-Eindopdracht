package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemTestedState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemTestedState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }
    
    @Override
    public String moveToToDo() {
        return "Can't move to toDo from tested.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move to doing from tested.";
    }

    @Override
    public String moveToReadyForTesting() {
        this.backlogComponent.setState(this.backlogComponent.getReadyForTestingState());
        return "Moved to readyForTesting.";
    }

    @Override
    public String moveToTesting() {
        return "Can't move to testing from tested.";
    }

    @Override
    public String moveToTested() {
        return "Can't move to tested from tested.";
    }

    @Override
    public String moveToDone() {
        this.backlogComponent.setState(this.backlogComponent.getDoneState());
        return "Moved to done";
    }

    @Override
    public String moveToClosed() {
        return "Can't move to closed from tested.";
    }
    
}
