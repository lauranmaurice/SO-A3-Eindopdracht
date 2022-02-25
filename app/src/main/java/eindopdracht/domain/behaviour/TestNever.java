package eindopdracht.domain.behaviour;

public class TestNever implements TestBehaviour {
    
    @Override
    public void test(){
        System.out.println("I am not allowed to test.");
    }

    @Override
    public boolean canTest(){
        return false;
    }

}
