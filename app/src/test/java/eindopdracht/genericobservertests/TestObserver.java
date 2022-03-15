package eindopdracht.genericobservertests;

import eindopdracht.domain.observers.Observer;

/**
 * TestObserver
 */
public class TestObserver extends Observer<String> {
    public String value;

	@Override
	public void update(String value) {
        this.value = value;
	}
    
}