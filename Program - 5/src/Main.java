import java.util.ArrayList;
import java.util.Scanner;

interface IStringList {
    void addString(String str);
    String getLongestString();
    String getShortestString();
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
    public String getLongestString() {
        if (strings.isEmpty()) {
            return null;
        }
        String longest = strings.get(0);
        for (String str : strings) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    @Override
    public String getShortestString() {
        if (strings.isEmpty()) {
            return null;
        }
        String shortest = strings.get(0);
        for (String str : strings) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add a string");
        System.out.println("2. Show results");
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
                    String longest = stringList.getLongestString();
                    String shortest = stringList.getShortestString();
                    if (longest != null && shortest != null) {
                        System.out.println("Longest string: " + longest);
                        System.out.println("Shortest string: " + shortest);
                    } else {
                        System.out.println("No strings to display.");
                    }
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
