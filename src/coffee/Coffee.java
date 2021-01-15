package coffee;

public abstract class Coffee {
    protected int water;
    protected int coffeeBeans;
    protected int cost;

    public Coffee() {
    }

    public int getWater() {
        return water;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getCost() {
        return cost;
    }
}
