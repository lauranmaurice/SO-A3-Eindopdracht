package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemClosedState implements ItemState{

    BacklogComponent backlogComponent;

    public ItemClosedState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }

    @Override
    public String moveToToDo() {
        return "Can't move from closed state.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move from closed state.";
    }

    @Override
    public String moveToReadyForTesting() {
        return "Can't move from closed state.";
    }

    @Override
    public String moveToTesting() {
        return "Can't move from closed state.";
    }

    @Override
    public String movedToTested() {
        return "Can't move from closed state.";
    }

    @Override
    public String moveToDone() {
        return "Can't move from closed state.";
    }

    @Override
    public String moveToClosed() {
        return "Can't move from closed state.";
    }
    
}
