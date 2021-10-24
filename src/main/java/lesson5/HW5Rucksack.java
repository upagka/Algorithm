package lesson5;


import java.util.HashSet;

public class HW5Rucksack {


    public static void main(String[] args) {
        HashSet<Thing> things = new HashSet<>();
        things.add(new Thing("Колбаса", 4,1000));
        things.add(new Thing("Гречка", 1,8000));
        things.add(new Thing("Ноутбук", 3,7000));
        things.add(new Thing("Тостер", 5,1200));
        things.add(new Thing("Гантеля", 10,1500));
        things.add(new Thing("Телевизор", 8,5000));
        int maxWeight = 4;
        System.out.println(bestThings(things, maxWeight));
    }

    private static HashSet bestThings(HashSet<Thing> things, int maxWeight) {

        //Если набор пустой
        if (things.isEmpty()){
            return things;
        }

        //Если набор входит в максимальный вес
        if (countWeight(things) <= maxWeight)
            return things;

        //Если набор из 1 вещи (но она тяжелее максимального веса)
        if (things.size() == 1){
            return new HashSet();
        }

        // Случай, когда набор состоит из 2+ вещей и тяжелее максимального веса.
        int maxPrice = 0;
        HashSet<Thing> copy = new HashSet<>(things); //Копия, чтобы не изменять things в итераторе.
        HashSet<Thing> theBest = new HashSet<>(); //Сохраняем сюда лучший из результатов
        HashSet<Thing> temp = new HashSet<>(); //Результат вызова рекурсии
        for (Thing thing : things) {
            copy.remove(thing);
            temp.clear();
            temp.addAll(bestThings(copy, maxWeight));
            if (!temp.isEmpty()) {
                if (countPrice(temp) > maxPrice){
                    theBest.clear();
                    theBest.addAll(temp);
                    maxPrice = countPrice(theBest);
                }
            }
            copy.add(thing);
        }
        if (maxPrice > 0)
        {
            System.out.println(maxPrice);
            return theBest;
        }
        return new HashSet();
    }

    private static int countPrice(HashSet<Thing> set) {
        int sum = 0;
        for (Thing thing : set) {
            sum = sum + thing.getPrice();
        }
        return sum;
    }

    private static int countWeight(HashSet<Thing> set) {
        int sum = 0;
        for (Thing thing : set) {
            sum = sum + thing.getWeight();
        }
        return sum;
    }


}
