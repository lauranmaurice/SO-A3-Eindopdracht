package eindopdracht.domain.backlog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import eindopdracht.domain.Person;

/**
 * BacklogComponent
 */
public abstract class BacklogComponent {

    private int number;
    private String title;
    private String description;
    private List<BacklogComponent> items;
    private boolean completed = false;

    @Nullable
    private Person developer;

    @Nullable
    private Person tester;
    

    public BacklogComponent(int number, String title, String description) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.items = new ArrayList<>();
    }

    public void setCompleted(@Nullable Boolean completed) {
        if (this.items.size() == 0) {
            this.completed = completed;
        } else {
            this.completed = this.isCompleted();
        }
    }

    public boolean isCompleted() {
        if(this.items.size() > 0) {
            return this.items.stream().allMatch(x -> x.isCompleted() == true);
        } 

        return this.completed;
    }

    public void addItem(BacklogComponent backlogComponent) {
        this.items.add(backlogComponent);
        this.setCompleted(null);  //always more than 0 items so this.completed is set using the getter
    }

    public void removeItem(BacklogComponent backlogComponent){
        this.items.remove(backlogComponent);
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