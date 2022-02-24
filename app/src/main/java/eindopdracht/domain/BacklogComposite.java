package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * BacklogComposite
 */
public class BacklogComposite extends BacklogComponent {
    private List<BacklogComponent> components;

    public BacklogComposite() {
        this.components = new ArrayList<>();
    }

    public List<BacklogComponent> getComponents() {
        return components;
    }

    public void addComponent(BacklogComponent component) {
        this.components.add(component);
    }

    public void removeComponent(BacklogComponent component) {
        this.components.remove(component);
    }
}