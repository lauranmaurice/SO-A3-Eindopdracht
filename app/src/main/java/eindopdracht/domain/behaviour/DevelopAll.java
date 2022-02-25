package eindopdracht.domain.behaviour;

public class DevelopAll implements DeveloperBehaviour{

    @Override
    public boolean canDevelop() {
        return true;
    }

    @Override
    public void develop() {
        System.out.println("Developing.");
    }
    
}
