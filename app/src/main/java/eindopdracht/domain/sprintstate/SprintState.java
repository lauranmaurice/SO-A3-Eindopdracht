package eindopdracht.domain.sprintstate;

public interface SprintState {
    
    public String startSprint();
    public String editSprint(String name, Integer number);
    public String completeSprint();
    public String releaseSprint();
    public String printErrorPipeline();
    public String succeedPipeline();
    public String cancelRelease();
    public String holdSprintReview();
    public String uploadReview();
}
