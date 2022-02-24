package eindopdracht.domain.personbehaviour;

/**
 * NoTesting
 */
public class NoTesting implements TestBehaviour{

    @Override
    public boolean test() {
        throw new UnsupportedOperationException("This idiot can't help you with testing, sorry");
    }

    
}