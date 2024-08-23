import java.util.ArrayList;
import java.util.Scanner;

interface ICharacterCounter {
    void addString(String str);
    void countNonVowelCharacters();
    void usePresetStrings();
}

class CharacterCounter implements ICharacterCounter {
    private final ArrayList<String> strings;
    private static final String[] PRESET_STRINGS = {
            "apple", "banana", "grape", "orange", "pear",
            "peach", "plum", "kiwi", "melon", "mango"
    };

    public CharacterCounter() {
        strings = new ArrayList<>();
    }

    @Override
    public void addString(String str) {
        strings.add(str);
    }

    @Override
    public void countNonVowelCharacters() {
        int count = 0;
        for (String str : strings) {
            for (char c : str.toCharArray()) {
                if (!isVowel(c) && Character.isLetter(c)) {
                    count++;
                }
            }
        }
        System.out.println("Total non-vowel characters: " + count);
    }

    @Override
    public void usePresetStrings() {
        for (String preset : PRESET_STRINGS) {
            addString(preset);
        }
        System.out.println("Preset strings have been added.");
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add a string");
        System.out.println("2. Count non-vowel characters");
        System.out.println("3. Use preset strings");
        System.out.println("4. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        CharacterCounter characterCounter = new CharacterCounter();
        int option;
        int stringCount = 0;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    if (stringCount < 10) {
                        System.out.println("Enter a string:");
                        String input = scanner.nextLine();
                        characterCounter.addString(input);
                        stringCount++;
                    } else {
                        System.out.println("You have already added 10 strings.");
                    }
                    break;
                case 2:
                    characterCounter.countNonVowelCharacters();
                    break;
                case 3:
                    characterCounter.usePresetStrings();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 4);
    }
}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
