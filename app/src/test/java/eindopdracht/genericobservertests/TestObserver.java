package eindopdracht.genericobservertests;

import eindopdracht.domain.observers.Observer;

/**
 * TestObserver
 */
public class TestObserver implements Observer<String> {
    public String value;

	@Override
	public void update(String value) {
        this.value = value;
	}
    
}