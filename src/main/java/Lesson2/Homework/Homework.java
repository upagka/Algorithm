package Lesson2.Homework;

public class Homework {
    public static void main(String[] args) {

        Notebook[] laptops = new Notebook[]{
                new Notebook("Asos", 1500, 8),
                new Notebook("Aces", 1800, 16),
                new Notebook("Maclap", 1000, 4),
                new Notebook("Xamiou", 2000, 24),
                new Notebook("pH", 2000, 8),
                new Notebook("Lenuva", 2000, 8),
                new Notebook("aces", 2000, 8),
                new Notebook("GL", 1800, 12),
                new Notebook("Asos", 1800, 12),
                new Notebook("Maclap", 1800, 12),
        };

        HeapSort.sort(laptops);


        for (Notebook laptop : laptops) {
            System.out.println(laptop);

        }
    }
}
