package eindopdracht.domain.personbehaviour;

/**
 * NoDevelop
 */
public class NoDevelop implements DeveloperBehaviour {

    @Override
    public void develop() {
        throw new UnsupportedOperationException("A non-developer is not able to develop");
    }

    
}