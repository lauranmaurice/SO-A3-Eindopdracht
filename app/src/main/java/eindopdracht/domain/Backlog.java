package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Backlog
 */
public class Backlog {
    private List<BacklogTask> items;

    public Backlog() { 
        this.items = new ArrayList<>();
    }

    public List<BacklogTask> getItems() {
        return items;
    }

    public void addItem(BacklogTask item) {
        this.items.add(item);
    }

    public void removeItem(BacklogTask item) {
        this.items.remove(item);
    }
}