package eindopdracht.domain.observers;

/**
 * Observer
 */
public abstract class Observer<T> {
    public abstract void update(T value);

    public void subscribeTo(Subject<T> subject) {
        subject.register(this);
    }

    public void unsubscribeFrom(Subject<T> subject) {
        subject.remove(this);
    }
}