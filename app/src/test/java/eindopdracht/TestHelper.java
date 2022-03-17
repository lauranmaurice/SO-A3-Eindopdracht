package eindopdracht;

import eindopdracht.domain.Person;
import eindopdracht.domain.behaviour.DevelopAll;
import eindopdracht.domain.behaviour.DevelopNever;
import eindopdracht.domain.behaviour.ScrumAll;
import eindopdracht.domain.behaviour.ScrumNever;
import eindopdracht.domain.behaviour.TestNever;

public class TestHelper {
    public static Person giveMeAScrumMaster() {
        var master = new Person("henk", "henk@mail.ru", "", new DevelopNever(), new TestNever(), new ScrumAll());
        return master;
    }

    public static Person giveMeADev() {
        var master = new Person("henk", "henk@mail.ru", "", new DevelopAll(), new TestNever(), new ScrumNever());
        return master;
    }
}
