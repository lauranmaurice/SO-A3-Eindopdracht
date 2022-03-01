package eindopdracht.domain.behaviour;

public class ScrumAll implements ScrumMasterBehaviour {

    @Override
    public boolean canScrum() {
        return true;        
    }

    @Override
    public String scrum() {
       return "Scrumming";        
    }
    
}
