import java.util.Scanner;

/**
 * Represents a subject with a name, credits, hours, and teacher.
 */
class Subject {
    String name;
    int credits;
    int hours;
    String teacher;

    /**
     * Constructs a new Subject.
     *
     * @param name    the name of the subject
     * @param credits the number of credits for the subject
     * @param hours   the number of hours for the subject
     * @param teacher the name of the teacher for the subject
     */
    Subject(String name, int credits, int hours, String teacher) {
        this.name = name;
        this.credits = credits;
        this.hours = hours;
        this.teacher = teacher;
    }

    /**
     * Displays the details of the subject.
     */
    void show() {
        System.out.println("Name: " + this.name);
        System.out.println("Credits: " + this.credits);
        System.out.println("Hours: " + this.hours);
        System.out.println("Teacher: " + this.teacher);
    }
}

/**
 * Represents a menu for managing subjects.
 */
class Menu {
    int size;

    /**
     * Constructs a new Menu with a specified size.
     *
     * @param size the number of subjects that can be managed
     */
    Menu(int subjectSize) {
        this.size = subjectSize;
    }

    /**
     * Displays the menu options.
     */
    void show() {
        System.out.println("1. Add subject");
        System.out.println("2. Show subjects");
        System.out.println("3. Exit");
    }

    /**
     * Gets the user's menu option.
     *
     * @return the selected menu option
     */
    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Adds a new subject to the list of subjects.
     *
     * @param subjects the array of subjects
     */
    void addSubject(Subject[] subjects) {
        System.out.print("\033[H\033[2J");
        Scanner scanner = new Scanner(System.in);
        String name, teacher;
        int credits, hours;
        try {
            System.out.println("Enter the name of the subject:");
            name = scanner.nextLine();
            System.out.println("Enter the number of credits:");
            credits = scanner.nextInt();
            System.out.println("Enter the number of hours:");
            hours = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of the teacher:");
            teacher = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }

        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                subjects[i] = new Subject(name, credits, hours, teacher);
                break;
            }
        }
    }

    /**
     * Displays the list of subjects.
     *
     * @param subjects the array of subjects
     */
    void showSubjects(Subject[] subjects) {
        for (Subject subject : subjects) {
            if (subject != null) {
                subject.show();
            }
        }
    }

    /**
     * Starts the menu and handles user input.
     */
    void start() {
        Subject[] subjects = new Subject[this.size];
        int option;

        do {
            show();
            option = getOption();

            switch (option) {
                case 1:
                    addSubject(subjects);
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    showSubjects(subjects);
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 3);
    }
}

/**
 * The main class to run the application.
 */
class Main {
    public static void main(String[] args) {
        int subjectSize;
        try {
            System.out.println("Enter the number of subjects you will enter:");
            Scanner scanner = new Scanner(System.in);
            subjectSize = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }
        Menu menu = new Menu(subjectSize);
        menu.start();
    }
}