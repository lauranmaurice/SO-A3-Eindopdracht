package eindopdracht.domain;

import eindopdracht.domain.backlog.Backlog;
import eindopdracht.domain.observers.Subject;
import eindopdracht.domain.observers.TaskObserver;
import eindopdracht.domain.sprintstate.SprintClosedState;
import eindopdracht.domain.sprintstate.SprintCreatedState;
import eindopdracht.domain.sprintstate.SprintFinishedState;
import eindopdracht.domain.sprintstate.SprintReviewDoneState;
import eindopdracht.domain.sprintstate.SprintRunningPipelineState;
import eindopdracht.domain.sprintstate.SprintStartedState;
import eindopdracht.domain.sprintstate.SprintState;

public class Sprint extends Subject<SprintState> {

    private String sprintName;
    private int sprintNumber;
    private Backlog backlog;
    private Forum forum;

    SprintState createdState;
    SprintState startedState;
    SprintState finishedState;
    SprintState runningPipelineState;
    SprintState reviewDoneState;
    SprintState closedState;

    SprintState state = createdState;

    public Sprint(String sprintName, int sprintNumber, Person scrumMaster) {
        this.setSprintName(sprintName);
        this.setSprintNumber(sprintNumber);

        var scrumMasterTaskObserver = new TaskObserver();
        scrumMaster.addMethods(scrumMasterTaskObserver);
        
        this.backlog = new Backlog(scrumMasterTaskObserver);
        this.forum = new Forum();

        createdState = new SprintCreatedState(this);
        startedState = new SprintStartedState(this);
        finishedState = new SprintFinishedState(this);
        runningPipelineState = new SprintRunningPipelineState(this);
        reviewDoneState = new SprintReviewDoneState(this);
        closedState = new SprintClosedState(this);
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

    public Backlog getBacklog() {
        return backlog;
    }

    public void setState(SprintState state){
        this.state = state;
        this.notify(state);
    }

    public SprintState getCreatedState(){
        return this.createdState;
    }

    public SprintState getStartedState(){
        return this.startedState;
    }
    
    public SprintState getFinishedState(){
        return this.finishedState;
    }

    public SprintState getRunningPipelineState(){
        return this.runningPipelineState;
    }

    public SprintState getReviewDoneState(){
        return this.reviewDoneState;
    }

    public SprintState getClosedState(){
        return this.closedState;
    }
    
    public String startSprint(){
        return this.state.startSprint();
    }

    public String editSprint(String name, Integer sprintNumber){
        return this.state.editSprint(name, sprintNumber);
    }

    public String completeSprint(){
        return this.state.completeSprint();
    }

    public String releaseSprint(){
        return this.state.releaseSprint();
    }

    public String printErrorPipeline(){
        return this.state.printErrorPipeline();
    }

    public String succeedPipeline(){
        return this.state.succeedPipeline();
    }

    public String cancelRelease(){
        return this.state.cancelRelease();
    }

    public String holdSprintReview(){
        return this.state.holdSprintReview();
    }

    public String uploadReview(){
        return this.state.uploadReview();
    }

    public SprintState getState(){
        return this.state;
    }
}