package eindopdracht.domain.behaviour;

public class TestAll implements TestBehaviour {

    @Override
    public boolean canTest() {
        return true;
    }

    @Override
    public void test() {
        System.out.println("Testing");
    }
    
}
