package Lesson3;

import java.util.ArrayList;

public class Deque<E>{
    ArrayList<E> deque = new ArrayList<E>();

    int maxLength;
    int start;
    int end = 0;
    int dequeLenght;

    public Deque(int maxLength) {
        int temp = maxLength;
        while(temp-- > 0) deque.add(null);
        start = maxLength - 1;
        this.maxLength = maxLength;
    }

    public boolean addToEnd(E element){
        if (dequeLenght == maxLength){
            System.out.println("No space in deque");
            return false;
        }
        deque.set(end, element);
        if (end == maxLength - 1) end = 0;
        else end++;
        dequeLenght++;
        return true;
    }

    public boolean addToStart(E element){
        if (dequeLenght == maxLength){
            System.out.println("No space in deque");
            return false;
        }
        deque.set(start, element);
        start--;
        dequeLenght++;
        return true;
    }


    @Override
    public String toString() {
        return "Deque{" +
                "deque=" + deque +
                ", maxLength=" + maxLength +
                ", dequeLength=" + dequeLenght +
                '}';
    }
}


