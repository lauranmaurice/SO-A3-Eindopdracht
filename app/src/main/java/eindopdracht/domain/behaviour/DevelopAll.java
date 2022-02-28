package eindopdracht.domain.behaviour;

public class DevelopAll implements DeveloperBehaviour{

    @Override
    public boolean canDevelop() {
        return true;
    }

    @Override
    public String develop() {
        return "Developing.";
    }
    
}
