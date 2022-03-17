package eindopdracht.domain.observers;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 */
public abstract class Subject<T> {
    private List<Observer<T>> observers;

    protected Subject()
    {
        observers = new ArrayList<>();
    }

    public void register(Observer<T> observer) {
        observers.add(observer);
    }

    public void remove(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notify(T value) {
        for (var o : observers) {
            o.update(value);
        }
    }
}