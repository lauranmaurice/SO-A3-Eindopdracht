package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemReadyForTestingState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemReadyForTestingState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }
    
    @Override
    public String moveToToDo() {
        return "Can't move to toDo from readyForTesting.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move to Doing from readyForTesting.";
    }

    @Override
    public String moveToReadyForTesting() {
        return "Can't move to readyForTesting from readyForTesting.";
    }

    @Override
    public String moveToTesting() {
        this.backlogComponent.setState(this.backlogComponent.getTestingState());
        return "Moved to testing.";
    }

    @Override
    public String moveToTested() {
        return "Can't move to tested from readyForTesting.";
    }

    @Override
    public String moveToDone() {
        return "Can't move to Done from readyForTesting.";
    }

    @Override
    public String moveToClosed() {
        return "Can't move to closed from readyForTesting.";
    }
    
}
