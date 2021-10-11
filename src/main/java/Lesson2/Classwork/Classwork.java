package Lesson2.Classwork;

import java.util.Arrays;

public class Classwork {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 17, 23, 19, 21, 24, 25, 14, 41, 5, 7, 24};
        int len = arr.length;
        int temp;
        boolean found = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    found = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(found == false) break;
            found = false;
            len--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
