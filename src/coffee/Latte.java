package coffee;

public class Latte extends Coffee {

    private final int milk;

    public Latte() {
        super.water = 350;
        milk = 75;
        super.coffeeBeans = 20;
        super.cost = 7;
    }

    public int getMilk() {
        return milk;
    }
}
