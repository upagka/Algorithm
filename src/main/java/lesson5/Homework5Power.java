package lesson5;

public class Homework5Power {
    public static void main(String[] args) {
        int number = 2;
        int power = 3;

        System.out.println(toPower(number, power));
    }

    private static int toPower(int number, int power) {
        if (power == 0){
            return 1;
        }
        if (power == 1){
            return  number;
        }
        return number * toPower(number, power - 1);
    }


}
