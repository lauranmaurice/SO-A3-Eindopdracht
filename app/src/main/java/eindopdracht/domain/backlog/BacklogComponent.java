package eindopdracht.domain.backlog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import eindopdracht.domain.Person;
import eindopdracht.domain.itemstate.ItemClosedState;
import eindopdracht.domain.itemstate.ItemDoingState;
import eindopdracht.domain.itemstate.ItemDoneState;
import eindopdracht.domain.itemstate.ItemReadyForTestingState;
import eindopdracht.domain.itemstate.ItemState;
import eindopdracht.domain.itemstate.ItemTestedState;
import eindopdracht.domain.itemstate.ItemTestingState;
import eindopdracht.domain.itemstate.ItemToDoState;
import eindopdracht.domain.observers.Subject;

/**
 * BacklogComponent
 */
public abstract class BacklogComponent extends Subject<ItemState> {

    private int number;
    private String title;
    private String description;
    private List<BacklogComponent> items;
    private boolean completed = false;

    @Nullable
    private BacklogComponent parent;

    @Nullable
    private Person developer;

    @Nullable
    private Person tester;

    ItemState closedState;
    ItemState doingState;
    ItemState doneState;
    ItemState readyForTestingState;
    ItemState testedState;
    ItemState testingState;
    ItemState toDoState;

    ItemState state;

    public BacklogComponent(int number, String title, String description) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.items = new ArrayList<>();
        
        this.closedState = new ItemClosedState(this);
        this.doingState = new ItemDoingState(this);
        this.doneState = new ItemDoneState(this);
        this.readyForTestingState = new ItemReadyForTestingState(this);
        this.testedState = new ItemTestedState(this);
        this.testingState = new ItemTestingState(this);
        this.toDoState = new ItemToDoState(this);
        
    }

    public ItemState getClosedState(){
        return this.closedState;
    }

    public ItemState getDoingState(){
        return this.doingState;
    }

    public ItemState getDoneState(){
        return this.doneState;
    }

    public ItemState getReadyForTestingState(){
        return this.readyForTestingState;
    }

    public ItemState getTestedState(){
        return this.testedState;
    }

    public ItemState getTestingState(){
        return this.testingState;
    }

    public ItemState getToDoState(){
        return this.toDoState;
    }

    public ItemState getState(){
        return this.state;
    }

    public String moveToToDo(){
        return this.state.moveToToDo();
    }

    public String moveToDoing(){
        return this.state.moveToDoing();
    }

    public String moveToReadyForTesting(){
        return this.state.moveToReadyForTesting();
    }

    public String moveToTesting(){
        return this.state.moveToTesting();
    }

    public String moveToTested(){
        return this.state.moveToTested();
    }

    public String moveToDone(){
        return this.state.moveToDone();
    }

    public String moveToClosed(){
        return this.state.moveToClosed();
    }
    
    public void setState(ItemState state) {
        this.state = state;
        this.notify(state);
    }
    

    public void setCompleted(@Nullable Boolean completed) {
        if (this.items.size() == 0) {
            this.completed = completed;
        } else {
            this.completed = this.isCompleted();
        }

        if(this.parent != null) {
            this.parent.setCompleted(null);
        }
    }

    public boolean isCompleted() {
        if(this.items.size() > 0) {
            return this.items.stream().allMatch(x -> x.isCompleted() == true);
        } 

        return this.completed;
    }

    public void addItem(BacklogComponent backlogComponent) {
        backlogComponent.parent = this;
        this.items.add(backlogComponent);
        this.setCompleted(null);  //always more than 0 items so this.completed is set using the getter
    }

    public void removeItem(BacklogComponent backlogComponent){
        this.items.remove(backlogComponent);
        backlogComponent.parent = null;
        this.setCompleted(false); // Possible to remove the last item.
    }

    public List<BacklogComponent> getItems(){
        return this.items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person getDeveloper() {
        return developer;
    }

    public void setDeveloper(@Nullable Person developer) {
        this.developer = developer;
    }

    public Person getTester() {
        return tester;
    }

    public void setTester(@Nullable Person tester) {
        this.tester = tester;
    }
}