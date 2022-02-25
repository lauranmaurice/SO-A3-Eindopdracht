package eindopdracht.domain.behaviour;

public class DevelopNever implements DeveloperBehaviour{

    @Override
    public boolean canDevelop() {
        return false;
    }

    @Override
    public void develop() {
        System.out.println("Not allowed to develop.");
    }
    
}
