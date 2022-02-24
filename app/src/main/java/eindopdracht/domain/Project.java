package eindopdracht.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Project
 */
public class Project {
    private List<Sprint> sprints;

    public Project() {
        this.sprints = new ArrayList<>();
    }

    public List<Sprint> getSprints() {
        return sprints;
    }
}