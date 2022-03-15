package eindopdracht.genericobservertests;

import eindopdracht.domain.observers.Subject;

/**
 * TestSubject
 */
public class TestSubject extends Subject<String> {
    private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
        this.notify(value);
	}
}