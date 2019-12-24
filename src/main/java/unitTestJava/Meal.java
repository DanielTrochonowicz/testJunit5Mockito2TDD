package unitTestJava;

import java.util.Objects;

public class Meal {

    private int price;
    private int quanity;
    private String name;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quanity, String name) {
        this.price = price;
        this.quanity = quanity;
        this.name = name;
    }

    public int getQuanity() {
        return quanity;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount){

        if(discount > this.price){
            throw new IllegalArgumentException("Discount cannot be higher that the price");
        }
        return this.price = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price &&
                Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
