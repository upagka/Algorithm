package Lesson2.Homework;

public class Notebook {

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    private String brand;

    private int price;

    private int ram;

    public Notebook(String brand, int price, int ram) {
        this.brand = brand;
        this.price = price;
        this.ram = ram;
    }

    public boolean isBetter(Notebook n){
        if (this.price > n.price) return true;
        if (this.price < n.price) return  false;
        if (this.ram > n.ram) return true;
        if (this.ram < n.ram) return false;
        if (this.brand.toLowerCase().compareTo(n.brand.toLowerCase()) > 1) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}
