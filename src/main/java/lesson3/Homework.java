package lesson3;

public class Homework {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №1 (нет числа 13)");
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,14,15,16};
        findAbsent(arr);

        System.out.println();
        System.out.println();
        System.out.println("Домашнее задание №2");

        Deque dogs = new Deque(5);
        dogs.addToEnd("Bobik");
        dogs.addToEnd(56);
        dogs.addToStart("Sharik");
        dogs.addToEnd("Gavryusha");
        System.out.println("Getting from end: " + dogs.getFromEnd());
        System.out.println(dogs);
        dogs.addToEnd("Mukhtar");
        System.out.println("Reading from start: " + dogs.readFromStart());
        System.out.println(dogs);
        dogs.addToEnd("Momo");
        System.out.println("Reading from end: " + dogs.readFromEnd());
        System.out.println(dogs);
        dogs.addToStart("Sharik");
        dogs.addToEnd("Tom");
        System.out.println("Getting from start: " + dogs.getFromStart());
        System.out.println(dogs);
        dogs.addToStart("Marusya");
        System.out.println("Getting from end: " + dogs.getFromEnd());
        System.out.println(dogs);

    }

    private static void findAbsent(int[] arr) {
        int start = 0;
        int end = arr.length;
        int index = (int) (arr.length -1) / 2;

        while (!(arr[index] == arr[index - 1] + 2)) //Проверка не является ли середина диапазона решением
        {
            if (arr[index] == index + 1) { //Если нарушений в середине диапазона нет, значит меняем start
                start = index + 1;
            }
            else {  //Иначе меняем конец диапазона (end)
                end = index;
            }
            index = (int) (start + end) / 2; //Находим новую середину диапазона
        }
        System.out.println("Пропущенное число: " + (index + 1));
    }
}
