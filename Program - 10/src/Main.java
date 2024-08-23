import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

interface IListProcessor {
    void removeDuplicates();
    void removeNonVowelStrings();
    void sortAlphabetically();
    void displayList();
}

class ListProcessor implements IListProcessor {
    private final List<String> strings;

    public ListProcessor(List<String> initialStrings) {
        this.strings = new ArrayList<>(initialStrings);
    }

    @Override
    public void removeDuplicates() {
        Set<String> uniqueStrings = new HashSet<>(strings);
        strings.clear();
        strings.addAll(uniqueStrings);
    }

    @Override
    public void removeNonVowelStrings() {
        strings.removeIf(str -> !containsVowel(str));
    }

    @Override
    public void sortAlphabetically() {
        Collections.sort(strings);
    }

    @Override
    public void displayList() {
        System.out.println("Current list:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    private boolean containsVowel(String str) {
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}

class Menu {
    public void show() {
        System.out.println("1. Remove duplicates");
        System.out.println("2. Remove strings without vowels");
        System.out.println("3. Sort alphabetically");
        System.out.println("4. Display list");
        System.out.println("5. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        List<String> initialStrings = List.of(
                "casa", "programación", "utp", "universidad", "utp", "casa",
                "casa", "thj", "vbh", "456", "987"
        );

        ListProcessor listProcessor = new ListProcessor(initialStrings);
        int option;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    listProcessor.removeDuplicates();
                    System.out.println("Duplicates removed.");
                    break;
                case 2:
                    listProcessor.removeNonVowelStrings();
                    System.out.println("Strings without vowels removed.");
                    break;
                case 3:
                    listProcessor.sortAlphabetically();
                    System.out.println("List sorted alphabetically.");
                    break;
                case 4:
                    listProcessor.displayList();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 5);
    }
}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
