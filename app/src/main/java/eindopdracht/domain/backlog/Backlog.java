package eindopdracht.domain.backlog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import eindopdracht.domain.observers.TaskObserver;

/**
 * Backlog
 */
public class Backlog {
    private List<BacklogComponent> items;

    @Nullable
    private TaskObserver scrumMasterTaskObserver;

    public Backlog(@Nullable TaskObserver scrumMasterTaskObserver) { 
        this.scrumMasterTaskObserver = scrumMasterTaskObserver;
        this.items = new ArrayList<>();
    }

    public void addItem(BacklogComponent item) {
        this.items.add(item);
        if(this.scrumMasterTaskObserver != null) {
            this.scrumMasterTaskObserver.subscribeTo(item);
        }
    }

    // epics functions
    public List<Epic> getEpics() {
        return items.stream().filter(Epic.class::isInstance).map(Epic.class::cast).toList();
    }

    public List<BacklogItem> getBacklogItems() {
        return items.stream()
            .filter(BacklogItem.class::isInstance)
            .map(BacklogItem.class::cast)
            .toList();
    }

    public List<BacklogComponent> getItems() {
        return items;
    }
}