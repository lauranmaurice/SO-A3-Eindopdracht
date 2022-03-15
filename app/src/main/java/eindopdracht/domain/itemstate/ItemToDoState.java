package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemToDoState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemToDoState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }

    @Override
    public String moveToToDo() {
        return "Can't move to toDo from toDo.";
    }

    @Override
    public String moveToDoing() {
        this.backlogComponent.setState(this.backlogComponent.getDoingState());
        return "Item moved to Doing.";
    }

    @Override
    public String moveToReadyForTesting() {
        return "Can't move to readyForTesting from toDo.";
    }

    @Override
    public String moveToTesting() {
        return "Can't move to testing from toDo.";
    }

    @Override
    public String movedToTested() {
        return "Can't move to tested from toDo.";
    }

    @Override
    public String moveToDone() {
        return "Can't move to done from toDo.";
    }

    @Override
    public String moveToClosed() {
        return "Can't move to closed from toDo.";
    }
    
}
