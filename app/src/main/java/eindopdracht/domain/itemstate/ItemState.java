package eindopdracht.domain.itemstate;

public interface ItemState {
    
    public String moveToToDo();
    public String moveToDoing();
    public String moveToReadyForTesting();
    public String moveToTesting();
    public String moveToTested();
    public String moveToDone();
    public String moveToClosed();

}
