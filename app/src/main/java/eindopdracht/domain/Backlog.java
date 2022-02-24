package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Backlog
 */
public class Backlog {
    private List<BacklogComponent> items;

    public Backlog() { 
        this.items = new ArrayList<>();
    }

    public List<BacklogComponent> getItems() {
        return items;
    }

    public void addItem(BacklogComponent item) {
        this.items.add(item);
    }

    public void removeItem(BacklogComponent item) {
        this.items.remove(item);
    }
}