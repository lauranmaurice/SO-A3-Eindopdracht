package eindopdracht.genericobservertests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * ObserverTests
 */
public class ObserverTests {

    @Test
    public void observersAllReceiveValue() {
        var observer1 = new TestObserver();
        var observer2 = new TestObserver();
        var subject = new TestSubject();

        subject.register(observer1);
        observer2.subscribeTo(subject);
        subject.setValue("Hello!");

        assertEquals(subject.getValue(), observer1.value);
        assertEquals(subject.getValue(), observer2.value);
    }

    @Test
    public void observerReceivesUpdate() {
        var observer = new TestObserver();
        var subject = new TestSubject();
        subject.register(observer);
        subject.setValue("1");
        assertEquals("1", observer.value);
        subject.setValue("2");
        assertEquals("2", observer.value);
    }

    @Test
    public void unsubscribedDoesntReceiveValue() {
        var observer1 = new TestObserver();
        var observer2 = new TestObserver();
        var observer3 = new TestObserver();
        var subject = new TestSubject();
        subject.register(observer1);
        subject.register(observer2);
        
        observer3.subscribeTo(subject);

        subject.setValue("1");
        assertEquals("1", observer1.value);
        assertEquals("1", observer2.value);
        assertEquals("1", observer3.value);

        subject.remove(observer1);
        observer3.unsubscribeFrom(subject);

        subject.setValue("2");
        assertEquals("1", observer1.value); //still one
        assertEquals("2", observer2.value); //updated
        assertEquals("1", observer3.value); //still one
    }
}