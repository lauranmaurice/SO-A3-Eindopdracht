package eindopdracht.domain.behaviour;

public class TestNever implements TestBehaviour {
    
    @Override
    public String test(){
        return "I am not allowed to test.";
    }

    @Override
    public boolean canTest(){
        return false;
    }

}
