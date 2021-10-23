package lesson4;

public class TestMain4 {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        var linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(4);
//        linkedList.re

        linkedList.display();


        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator


        //Мой итератор удаляет элементы из списка, если я использую встроенный метод removeFirst.
        //Пришлось сделать реализацию в Iterator, чтобы элементы не удалялись. Верно ли это?
        for (Object value : linkedList) {
            System.out.println("value: " + value);
        }

        linkedList.display();

        System.out.println("\n\nВторое задание:");

        Deque<String> deque = new DequeImpl<>();
        deque.insertFirst("Первый");
        deque.insertFirst("Второй");
        deque.insertLast("Третий");
        System.out.println(deque.readFirst());
        System.out.println(deque.getLast());
        deque.insertFirst("Четвертый");
        deque.insertLast("Пятый");
        deque.insertLast("Шестой");
        deque.insertFirst("Седьмой");
        System.out.println(deque.getLast());
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());

    }




}
