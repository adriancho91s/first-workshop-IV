import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

interface INumberProcessor {
    void generateRandomNumbers(int count);
    void displayNumbersWithPowers();
}

class NumberProcessor implements INumberProcessor {
    private final List<Integer> numbers;
    private final Random random;

    public NumberProcessor() {
        numbers = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void generateRandomNumbers(int count) {
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(100) + 1;
            numbers.add(number);
        }
    }

    @Override
    public void displayNumbersWithPowers() {
        System.out.println("Number - Square - Cube");
        for (int number : numbers) {
            int square = number * number;
            int cube = number * number * number;
            System.out.printf("%d - %d - %d\n", number, square, cube);
        }
    }
}

class Menu {
    public void show() {
        System.out.println("1. Generate random numbers");
        System.out.println("2. Display numbers with their square and cube");
        System.out.println("3. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        NumberProcessor numberProcessor = new NumberProcessor();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    numberProcessor.generateRandomNumbers(15);
                    System.out.println("15 random numbers have been generated.");
                    break;
                case 2:
                    numberProcessor.displayNumbersWithPowers();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 3);
    }
}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
