import coffee.Cappuccino;
import coffee.Espresso;
import coffee.Latte;

import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        getNumberIngredients();
        System.out.println();
        chooseAction();
        System.out.println();
        getNumberIngredients();

    }

    private static void getNumberIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

//    private static void getCupOfCoffee() {
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        int water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        int coffee = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        int cups = scanner.nextInt();
//
//        int numberCups = water / CoffeeMachine.water;
//
//        if (numberCups > milk / CoffeeMachine.milk) {
//            numberCups = milk / CoffeeMachine.milk;
//        }
//        if (numberCups > coffee / coffeeBeans) {
//            numberCups = coffee / coffeeBeans;
//        }
//
//        if (cups == numberCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (cups > numberCups) {
//            System.out.printf("No, I can make only %d cup(s) of coffee\n", numberCups);
//        } else {
//            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", numberCups - cups);
//        }
//        scanner.close();
//    }

    private static void chooseAction() {
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

        if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int chose = scanner.nextInt();
            getCoffee(chose);
        } else if (action.equals("fill")) {
            fillMachine();
        } else if (action.equals("take")) {
            System.out.println("I gave you $" + money);
            CoffeeMachine.money = 0;
        }
        scanner.close();
    }

    private static void getCoffee(int chose) {
        if (chose == 1) {
            Espresso espresso = new Espresso();
            water = water - espresso.getWater();
            coffeeBeans = coffeeBeans - espresso.getCoffeeBeans();
            money = money + espresso.getCost();
            disposableCups = disposableCups - 1;
        }
        if (chose == 2) {
            Latte latte = new Latte();
            water = water - latte.getWater();
            milk = milk - latte.getMilk();
            coffeeBeans = coffeeBeans - latte.getCoffeeBeans();
            money = money + latte.getCost();
            disposableCups = disposableCups - 1;
        }
        if (chose == 3) {
            Cappuccino cappuccino = new Cappuccino();
            water = water - cappuccino.getWater();
            milk = milk - cappuccino.getMilk();
            coffeeBeans = coffeeBeans - cappuccino.getCoffeeBeans();
            money = money + cappuccino.getCost();
            disposableCups = disposableCups - 1;
        }
    }
    
    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        CoffeeMachine.water = CoffeeMachine.water + water;
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        CoffeeMachine.milk = CoffeeMachine.milk + milk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int coffee = scanner.nextInt();
        CoffeeMachine.coffeeBeans = CoffeeMachine.coffeeBeans + coffee;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cup = scanner.nextInt();
        CoffeeMachine.disposableCups = CoffeeMachine.disposableCups + cup;
    }
}

