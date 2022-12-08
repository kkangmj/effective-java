package Item79.ex3;


@FunctionalInterface
public interface SetObserver<E> {

    void added(ObservableSet<E> set, E element);
}