import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);
    private final static int waterForOneCup = 200;
    private final static int milkForOneCup = 50;
    private final static int coffeeBeansForOneCup = 15;

    public static void main(String[] args) {
        getCupOfCoffee();
    }

    private static void getNumberIngredients() {
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.println(cups * waterForOneCup + " ml of water");
        System.out.println(cups * milkForOneCup + " ml of milk");
        System.out.println(cups * coffeeBeansForOneCup + " g of coffee beans");
        scanner.close();
    }

    private static void menu() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    private static void getCupOfCoffee() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        int numberCups = water / waterForOneCup;

        if (numberCups > milk / milkForOneCup) {
            numberCups = milk / milkForOneCup;
        }
        if (numberCups > coffee / coffeeBeansForOneCup) {
            numberCups = coffee / coffeeBeansForOneCup;
        }

        if (cups == numberCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > numberCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", numberCups);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", numberCups - cups);
        }
        scanner.close();
    }
}
