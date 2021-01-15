package coffee;

public class Cappuccino extends Coffee {

    private int milk;

    public Cappuccino() {
        super.water = 200;
        milk = 100;
        super.coffeeBeans = 12;
        super.cost = 6;
    }

    public int getMilk() {
        return milk;
    }
}
