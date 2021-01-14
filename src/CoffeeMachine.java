import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getNumberIngredients();
    }

    private static void getNumberIngredients() {
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");
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
}
