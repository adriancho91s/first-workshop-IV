import java.util.ArrayList;
import java.util.Scanner;

interface IStringList {
    void addString(String str);
    void showStringsOfLength(int length);
}

class StringList implements IStringList {
    private final ArrayList<String> strings;

    public StringList() {
        strings = new ArrayList<>();
    }

    @Override
    public void addString(String str) {
        strings.add(str);
    }

    @Override
    public void showStringsOfLength(int length) {
        boolean found = false;
        for (String str : strings) {
            if (str.length() == length) {
                System.out.println(str);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No strings with length " + length);
        }
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add a string");
        System.out.println("2. Show strings by length");
        System.out.println("3. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        StringList stringList = new StringList();
        int option;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    System.out.println("Enter a string:");
                    String input = scanner.nextLine();
                    stringList.addString(input);
                    break;
                case 2:
                    System.out.println("Enter the length of strings to display:");
                    int length = scanner.nextInt();
                    stringList.showStringsOfLength(length);
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
