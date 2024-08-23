import java.util.ArrayList;
import java.util.Scanner;

interface IStringList {
    void addString(String str);
    void showStringsContainingChar(char character);
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
    public void showStringsContainingChar(char character) {
        boolean found = false;
        for (String str : strings) {
            if (str.indexOf(character) >= 0) {
                String lengthType = (str.length() % 2 == 0) ? "Even" : "Odd";
                System.out.printf("%s - %s length\n", str, lengthType);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No strings contain the character '" + character + "'");
        }
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add a string");
        System.out.println("2. Show strings containing a specific character");
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
                    System.out.println("Enter a character to search for:");
                    char character = scanner.nextLine().charAt(0);
                    stringList.showStringsContainingChar(character);
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
