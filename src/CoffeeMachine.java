import coffee.Cappuccino;
import coffee.Coffee;
import coffee.Espresso;
import coffee.Latte;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;
    private static final Espresso espresso = new Espresso();
    private static final Latte latte = new Latte();
    private static final Cappuccino cappuccino = new Cappuccino();

    public static void main(String[] args) {
        chooseAction();
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
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String[] line = scanner.nextLine().split(";");

            for (String action : line) {
                System.out.println();
                switch (action.trim()) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                        String chose = scanner.nextLine();
                        if (chose.equals("back\n")) {
                            continue;
                        } else {
                            getCoffee(Integer.parseInt(chose));
                        }
                        break;
                    case "fill":
                        fillMachine();
                        break;
                    case "take":
                        System.out.println("I gave you $" + money);
                        CoffeeMachine.money = 0;
                        break;
                    case "remaining":
                        getNumberIngredients();
                        break;
                    case "exit":
                        scanner.close();
                        return;
                }
            }
            System.out.println();
        }
    }

    private static void getCoffee(int chose) {
        if (chose == 1) {
            if (checkEnoughIng(espresso)) {
                water = water - espresso.getWater();
                coffeeBeans = coffeeBeans - espresso.getCoffeeBeans();
                money = money + espresso.getCost();
                disposableCups = disposableCups - 1;
            }
        }
        if (chose == 2) {
            if (checkEnoughIng(latte)) {
                water = water - latte.getWater();
                milk = milk - latte.getMilk();
                coffeeBeans = coffeeBeans - latte.getCoffeeBeans();
                money = money + latte.getCost();
                disposableCups = disposableCups - 1;
            }
        }
        if (chose == 3) {
            if (checkEnoughIng(cappuccino)) {
                water = water - cappuccino.getWater();
                milk = milk - cappuccino.getMilk();
                coffeeBeans = coffeeBeans - cappuccino.getCoffeeBeans();
                money = money + cappuccino.getCost();
                disposableCups = disposableCups - 1;
            }
        }
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        String water = scanner.nextLine();
        CoffeeMachine.water = CoffeeMachine.water + Integer.parseInt(water);
        System.out.println("Write how many ml of milk do you want to add: ");
        String milk = scanner.nextLine();
        CoffeeMachine.milk = CoffeeMachine.milk + Integer.parseInt(milk);
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        String coffee = scanner.nextLine();
        CoffeeMachine.coffeeBeans = CoffeeMachine.coffeeBeans + Integer.parseInt(coffee);
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        String cup = scanner.nextLine();
        CoffeeMachine.disposableCups = CoffeeMachine.disposableCups + Integer.parseInt(cup);
        System.out.println();
    }

    private static boolean checkEnoughIng(Coffee coffee) {
        if (water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeans < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans");
            return false;
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }
}

