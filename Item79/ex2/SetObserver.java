package Item79.ex2;


@FunctionalInterface
public interface SetObserver<E> {

    void added(ObservableSet<E> set, E element);
}