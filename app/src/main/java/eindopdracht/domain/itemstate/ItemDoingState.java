package eindopdracht.domain.itemstate;

import eindopdracht.domain.backlog.BacklogComponent;

public class ItemDoingState implements ItemState{


    BacklogComponent backlogComponent;

    public ItemDoingState(BacklogComponent backlogComponent){
        this.backlogComponent = backlogComponent;
    }
    
    @Override
    public String moveToToDo() {
        return "Can't move to toDo from doing.";
    }

    @Override
    public String moveToDoing() {
        return "Can't move to doing from doing.";
    }

    @Override
    public String moveToReadyForTesting() {
        if(this.backlogComponent.isCompleted()){
            this.backlogComponent.setState(this.backlogComponent.getReadyForTestingState());
            return "Moved to readyForTesting.";
        } else {
            return "Is not completed yet.";
        }

    }

    @Override
    public String moveToTesting() {
        return "Can't move to testing from doing.";
    }

    @Override
    public String moveToTested() {
        return "Can't move to tested from doing.";
    }

    @Override
    public String moveToDone() {
        return "Can't move to done from doing.";
    }

    @Override
    public String moveToClosed() {
        return "Can't move to closed from doing.";
    }
    
}
