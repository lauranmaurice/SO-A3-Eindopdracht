package eindopdracht.domain.observers;

/**
 * Observer
 */
public interface Observer<T> {
    public void update(T value);

    public default void subscribeTo(Subject<T> subject) {
        subject.register(this);
    }

    public default void unsubscribeFrom(Subject<T> subject) {
        subject.remove(this);
    }
}