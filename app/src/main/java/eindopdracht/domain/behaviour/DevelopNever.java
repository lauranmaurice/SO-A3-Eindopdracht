package eindopdracht.domain.behaviour;

public class DevelopNever implements DeveloperBehaviour{

    @Override
    public boolean canDevelop() {
        return false;
    }

    @Override
    public String develop() {
        return "Not allowed to develop.";
    }
    
}
