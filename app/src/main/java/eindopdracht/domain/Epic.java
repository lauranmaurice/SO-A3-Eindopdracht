package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class Epic {

    private int number;
    private String title;
    private String description;
    private List<BacklogItem> items;
    private boolean completed = false;

    public Epic(int number, String title, String description){
        setNumber(number);
        setTitle(title);
        setDescription(description);
        items = new ArrayList<>();
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<BacklogItem> getItems() {
        return items;
    }
    
    public void addItem(BacklogItem item){
        this.items.add(item);
    }

    public void removeItem(BacklogItem item){
        this.items.remove(item);
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
    
}
