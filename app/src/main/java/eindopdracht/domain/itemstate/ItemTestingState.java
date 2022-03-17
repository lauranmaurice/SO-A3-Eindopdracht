package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemTestingState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemTestingState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }
    
    @Override
    public String moveToToDo() {
        this.backlogComponent.setState(this.backlogComponent.getToDoState());
        return "Item moved to toDo.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move to doing from testing.";
    }

    @Override
    public String moveToReadyForTesting() {
        return "Can't move to readyForTesting from testing.";
    }

    @Override
    public String moveToTesting() {
        return "Can't move to testing from testing.";
    }

    @Override
    public String moveToTested() {
        this.backlogComponent.setState(this.backlogComponent.getTestedState());
        return "Item moved to tested.";
    }

    @Override
    public String moveToDone() {
        return "Can't move to done from testing.";
    }

    @Override
    public String moveToClosed() {
        return "Can't move to closed from testing.";
    }
    
}
