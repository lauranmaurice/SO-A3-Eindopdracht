package eindopdracht.domain;

/**
 * Sprint
 */
public class Sprint {

    private Backlog backlog;
    private int sprintNumber;

    public Sprint(Backlog backlog, int sprintNumber) {
        this.setBacklog(backlog);
        this.setSprintNumber(sprintNumber);
    }

    public int getSprintNumber() {
        return sprintNumber;
    }

    public void setSprintNumber(int sprintNumber) {
        this.sprintNumber = sprintNumber;
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
    
}