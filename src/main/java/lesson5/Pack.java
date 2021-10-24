package lesson5;

import java.util.HashSet;

public class Pack {
    private HashSet<Thing> pack = new HashSet<>();
    private int weight;

    public Pack(HashSet<Thing> pack, int weight) {
        this.pack = pack;
        this.weight = weight;
    }

    public Pack(HashSet<Thing> pack) {
        this.pack = pack;
    }

    public HashSet<Thing> getPack() {
        return pack;
    }

    public void setPack(HashSet<Thing> pack) {
        this.pack = pack;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
