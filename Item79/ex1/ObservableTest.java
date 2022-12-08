package Item79.ex1;

import Item79.ex1.ObservableSet;

import java.util.HashSet;

public class ObservableTest {

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
