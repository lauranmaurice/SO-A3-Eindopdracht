package eindopdracht.domain.behaviour;

public class ScrumAll implements ScrumMasterBehaviour {

    @Override
    public boolean canScrum() {
        return true;        
    }

    @Override
    public void scrum() {
       System.out.println("Scrumming");        
    }
    
}
