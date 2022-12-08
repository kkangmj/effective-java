package Item79.ex1;

import Item79.ex1.ObservableSet;

@FunctionalInterface
public interface SetObserver<E> {

    void added(ObservableSet<E> set, E element);
}
