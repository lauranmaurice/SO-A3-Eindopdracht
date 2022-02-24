package eindopdracht.domain;

/**
 * Sprint
 */
public class Sprint {

    private String sprintName;
    private int sprintNumber;
    private Backlog backlog;
    private Forum forum;

    

    public Sprint(String sprintName, int sprintNumber, Backlog backlog, Forum forum) {
        this.setSprintName(sprintName);
        this.setSprintNumber(sprintNumber);
        this.setBacklog(backlog);
        this.setForum(forum);
    }

    // forum functions
    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    // functions sprintName
    public String getSprintName(){
        return this.sprintName;
    }

    public void setSprintName(String sprintName){
        this.sprintName = sprintName;
    }

    // functions sprintNumber
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

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
    
}