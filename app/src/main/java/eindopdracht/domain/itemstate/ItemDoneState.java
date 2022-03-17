package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemDoneState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemDoneState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }
    
    @Override
    public String moveToToDo() {
        this.backlogComponent.setState(this.backlogComponent.getToDoState());
        this.backlogComponent.setCompleted(false);
        return "Moved to toDo.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move to doing from done.";
    }

    @Override
    public String moveToReadyForTesting() {
        return "Can't move to readyForTesting from done.";
    }

    @Override
    public String moveToTesting() {
        return "Can't move to testing from done.";
    }

    @Override
    public String moveToTested() {
        return "Can't move to tested from done.";
    }

    @Override
    public String moveToDone() {
        return "Can't move to done from done.";
    }

    @Override
    public String moveToClosed() {
        this.backlogComponent.setState(this.backlogComponent.getClosedState());
        return "Moved to closed.";
    }
    
}
