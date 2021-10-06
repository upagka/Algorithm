package Lesson1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Homework {
    static int num = 0;
    public static void main(String[] args) {

        System.out.println(fib(BigInteger.valueOf(40)));
        System.out.println(num);
    }

    public static BigInteger fib(BigInteger n) {
        num++;
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;

        }
        if (n.equals(BigInteger.TWO)) {
           return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }
}
