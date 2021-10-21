package lesson4;

public interface Deque<E> {

    void insertFirst(E value);

    E getFirst();

    E readFirst();

    void insertLast(E value);

    E getLast();

    E readLast();

}
