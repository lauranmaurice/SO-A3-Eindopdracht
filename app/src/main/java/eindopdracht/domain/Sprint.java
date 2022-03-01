package eindopdracht.domain;

import eindopdracht.domain.backlog.Backlog;

/**
 * Sprint
 */
public class Sprint {

    private String sprintName;
    private int sprintNumber;
    private Backlog backlog;
    private Forum forum;

    

    public Sprint(String sprintName, int sprintNumber) {
        this.setSprintName(sprintName);
        this.setSprintNumber(sprintNumber);
        this.backlog = new Backlog();
        this.forum = new Forum();
    }

    public Forum getForum() {
        return forum;
    }

    public String getSprintName(){
        return this.sprintName;
    }

    public void setSprintName(String sprintName){
        this.sprintName = sprintName;
    }

    public int getSprintNumber() {
        return sprintNumber;
    }

    public void setSprintNumber(int sprintNumber) {
        this.sprintNumber = sprintNumber;
    }

    // functions backlog
    public Backlog getBacklog() {
        return backlog;
    }
    
}