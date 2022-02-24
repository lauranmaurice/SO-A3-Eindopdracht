package eindopdracht.domain.personbehaviour;

/**
 * NoMaster
 */
public class NoMaster implements ScrumMasterBehaviour {

	@Override
	public boolean doScrum() {
		throw new UnsupportedOperationException("A non-scrummaster is not able to do scrum");
	}

    
}