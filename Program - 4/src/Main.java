import java.util.ArrayList;
import java.util.Scanner;

interface INumber {
    int getValue();
    int getSquare();
    int getCube();
}

class Number implements INumber {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getSquare() {
        return value * value;
    }

    @Override
    public int getCube() {
        return value * value * value;
    }

    public void showNumberDetails() {
        System.out.printf("%d - %d - %d\n", getValue(), getSquare(), getCube());
    }
}

class NumberList {
    private final ArrayList<Number> numbers;

    public NumberList() {
        numbers = new ArrayList<>();
    }

    public void addNumber(Number number) {
        numbers.add(number);
    }

    public void fillNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of integers you want to input:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter integer %d:\n", i + 1);
            int value = scanner.nextInt();
            Number number = new Number(value);
            addNumber(number);
        }
    }

    public void showResults() {
        for (Number number : numbers) {
            number.showNumberDetails();
        }
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add numbers");
        System.out.println("2. Show results");
        System.out.println("3. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        NumberList numberList = new NumberList();
        int option;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    numberList.fillNumbers();
                    break;
                case 2:
                    numberList.showResults();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
            System.out.print("\033[H\033[2J");
        } while (option != 3);
    }
}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
