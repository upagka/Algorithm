package Lesson2.Classwork;


public class Main {
    public static void main(String[] args) {
        MyArray.isRepeat = false;
        MyArray.isShuffle = true;
        final int SIZE = 50000;
        Integer[] arr = MyArray.getArray(SIZE, 3);

        MyArray.shuffleArray(arr);
//        System.out.println(Arrays.toString(arr));

        SpeedTest.startTime();

//       HeapSort.sort(arr);

        SpeedTest.endTime();

//        System.out.println(Arrays.toString(arr));
    }
}
