package lesson4;

public class DequeImpl<E> implements Deque<E> {
    TwoSideLinkedListImpl<E> deque = new TwoSideLinkedListImpl<>();

    @Override
    public void insertFirst(E value) {
        deque.insertFirst(value);
    }

    @Override
    public E getFirst() {
        return deque.removeFirst();
    }

    @Override
    public E readFirst() {
        return deque.getFirst();
    }

    @Override
    public void insertLast(E value) {
        deque.insertLast(value);
    }

    @Override
    public E getLast() {
        return deque.removeLast();
    }

    @Override
    public E readLast() {
        return deque.getLast();
    }
}
