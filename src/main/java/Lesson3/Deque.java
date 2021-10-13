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
        System.out.println(element + " was added to deque at the end.");
        System.out.println(deque);
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
        System.out.println(element + " was added to deque at the start.");
        System.out.println(deque);
        return true;
    }

    public E getFromEnd() {
        if (dequeLenght == 0) return null;
        E value;
        if (end == 0) {
            value = deque.get(maxLength - 1);
            deque.set(maxLength - 1, null);
            end = maxLength - 1;
            dequeLenght--;
        } else {
            value = deque.get(end - 1);
            deque.set(end - 1, null);
            end--;
            dequeLenght--;
        }
        return value;
    }
    public E getFromStart() {
        if (dequeLenght == 0) return null;
        E value;
        if (start == maxLength - 1) {
            value = deque.get(0);
            deque.set(0, null);
            start = 0;
            dequeLenght--;
        } else {
            value = deque.get(start + 1);
            deque.set(start + 1, null);
            start++;
            dequeLenght--;
        }
        return value;
    }

    public E readFromEnd() {
        if (dequeLenght == 0) return null;
        if (end == 0) return deque.get(maxLength - 1);
        return deque.get(end - 1);
    }

    public E readFromStart() {
        if (dequeLenght == 0) return null;
        if (start == maxLength - 1) return deque.get(0);
        return deque.get(start + 1);
    }

    @Override
    public String toString() {
        return "Deque{" +
                "deque=" + deque +
                ", maxLength=" + maxLength +
                ", dequeLength=" + dequeLenght +
                '}';
    }

    public int getDequeLenght() {
        return dequeLenght;
    }
}


