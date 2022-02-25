package eindopdracht.domain.behaviour;

public class ScrumNever implements ScrumMasterBehaviour {

    @Override
    public boolean canScrum() {
        return false;
    }

    @Override
    public void scrum() {
        System.out.println("Can't scrum.");
    }
    
}
