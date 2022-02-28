package eindopdracht.domain.backlog;

import eindopdracht.domain.Person;

/**
 * Epic
 */
public class Epic extends BacklogComponent {

    public Epic(int number, String title, String description) {
        super(number, title, description);
    }

    @Override
    public void setDeveloper(Person developer) {
        throw new UnsupportedOperationException("Cannot assign a developer to an epic");
    }

    @Override
    public void setTester(Person tester) {
        throw new UnsupportedOperationException("Cannot assign a tester to an epic.");
    }
}
