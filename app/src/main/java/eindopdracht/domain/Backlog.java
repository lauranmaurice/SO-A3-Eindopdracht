package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Backlog
 */
public class Backlog {
    private List<BacklogItem> items;
    private List<Epic> epics;

    public Backlog() { 
        this.items = new ArrayList<>();
        this.epics = new ArrayList<>();
    }

    // epics functions
    public List<Epic> getEpics() {
        return epics;
    }

    public void addEpic(Epic epic) {
        this.epics.add(epic);
    }

    public void removeEpic(Epic epic) {
        this.epics.remove(epic);
    }

    // items functions
    public List<BacklogItem> getItems() {
        return items;
    }

    public void addItem(BacklogItem item) {
        this.items.add(item);
    }

    public void removeItem(BacklogItem item) {
        this.items.remove(item);
    }
}