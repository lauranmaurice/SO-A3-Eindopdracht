package eindopdracht.domain.behaviour;

public class ScrumNever implements ScrumMasterBehaviour {

    @Override
    public boolean canScrum() {
        return false;
    }

    @Override
    public String scrum() {
        return "Can't scrum.";
    }
    
}
