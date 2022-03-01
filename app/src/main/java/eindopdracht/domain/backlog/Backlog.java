package eindopdracht.domain.backlog;

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

    public void addItem(BacklogComponent item) {
        this.items.add(item);
    }

    // epics functions
    public List<Epic> getEpics() {

        return items.stream().filter(Epic.class::isInstance).map(s -> (Epic)s).toList();
    }

    public List<BacklogItem> getBacklogItems() {

        return items.stream()
            .filter(BacklogItem.class::isInstance)
            .map(s -> (BacklogItem)s)
            .toList();
    }

    public List<BacklogComponent> getItems() {
        return items;
    }
}