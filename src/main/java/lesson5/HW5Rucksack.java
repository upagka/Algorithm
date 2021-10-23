package lesson5;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HW5Rucksack {


    public static void main(String[] args) {
        Set<Thing> things = new HashSet<>();
        things.add(new Thing("Колбаса", 4,1000));
        things.add(new Thing("Гречка", 1,8000));
        things.add(new Thing("Ноутбук", 3,7000));
        things.add(new Thing("Тостер", 5,1200));
        things.add(new Thing("Гантеля", 10,500));
        things.add(new Thing("Телевизор", 8,5000));
        int maxWeight = 30;
        System.out.println(bestThings(things, maxWeight));
    }

    private static HashSet bestThings(Set<Thing> things, int maxWeight) {
        if (things == null){
            return null;
        }
        int sum = 0;
        for (Thing thing : things) {
            sum = sum + thing.getWeight();
        }
        if (sum <= maxWeight){
            return (HashSet) things;
        }
        Thing pantry = null;
        Thing without = null;
        int max = 0;
        int maxPrice = 0;
        Set<Thing> copy = new HashSet<>(things);
        for (Thing thing : things) {
            copy.remove(thing);
            if (countWeight((HashSet<Thing>) copy) <= maxWeight && countPrice((HashSet<Thing>) copy) > maxPrice){
                without = new Thing(thing.getName(),thing.getWeight(),thing.getPrice());
                max = countWeight((HashSet<Thing>) copy);
                maxPrice = countPrice((HashSet<Thing>) copy);

            }
            copy.add(thing);
        }
        if(max != 0){
            System.out.println(without);
            things.remove(without);
            return (HashSet) things;
        }
        return  null;
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
