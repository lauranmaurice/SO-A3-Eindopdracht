package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

public class Epic {

    private int number;
    private String title;
    private String description;
    private List<BacklogItem> items;

    public Epic(int number, String title, String description){
        setNumber(number);
        setTitle(title);
        setDescription(description);
        items = new ArrayList<>();
    }

    // items functions
    public List<BacklogItem> getItems() {
        return items;
    }
    
    public void addItem(BacklogItem item){
        this.items.add(item);
    }

    public void removeItem(BacklogItem item){
        this.items.remove(item);
    }

    // description functions
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // title functions
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // number functions
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
