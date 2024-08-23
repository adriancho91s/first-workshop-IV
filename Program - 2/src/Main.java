import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface representing a subject.
 */
interface ISubject {
    /**
     * Gets the name of the subject.
     *
     * @return the name of the subject
     */
    String getName();
}

/**
 * Class representing a subject.
 */
class Subject implements ISubject {
    private String name;
    private int credits;
    private int hours;
    private String teacher;

    /**
     * Constructs a new Subject.
     *
     * @param name the name of the subject
     * @param credits the number of credits for the subject
     * @param hours the number of hours for the subject
     * @param teacher the name of the teacher for the subject
     */
    public Subject(String name, int credits, int hours, String teacher) {
        this.name = name;
        this.credits = credits;
        this.hours = hours;
        this.teacher = teacher;
    }

    /**
     * Gets the name of the subject.
     *
     * @return the name of the subject
     */
    @Override
    public String getName() {
        return name;
    }
}

/**
 * Class representing a student.
 */
class Student {
    private final ArrayList<ISubject> subjects;

    /**
     * Constructs a new Student.
     */
    public Student() {
        subjects = new ArrayList<>();
    }

    /**
     * Adds a subject to the student's list of subjects.
     *
     * @param subject the subject to add
     */
    public void addSubject(ISubject subject) {
        subjects.add(subject);
    }

    /**
     * Prints the names of the subjects the student is studying.
     * If no subjects are present, it prints a message indicating that.
     */
    public void saySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects to show");
            return;
        }
        for (ISubject subject : subjects) {
            if (subject != null) {
                System.out.println("I study " + subject.getName());
            }
        }
    }

    /**
     * Fills the student's list of subjects by prompting the user for input.
     * Continues to prompt until the user types 'exit'.
     */
    public void fillSubjects() {
        Scanner scanner = new Scanner(System.in);
        String name, teacher;
        int credits, hours;

        do {
            System.out.println("Enter the name of the subject:");
            name = scanner.nextLine();
            System.out.println("Enter the number of credits for the subject:");
            credits = scanner.nextInt();
            System.out.println("Enter the number of hours for the subject:");
            hours = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of the teacher for the subject:");
            teacher = scanner.nextLine();
            ISubject subject = new Subject(name, credits, hours, teacher);
            addSubject(subject);
            System.out.println("Press enter to add another subject or type 'exit' to finish");
            name = scanner.nextLine();
        } while (!name.equalsIgnoreCase("exit"));
    }
}

/**
 * Class representing a menu.
 */
class Menu {
    /**
     * Displays the menu options to the user.
     */
    public void show() {
        System.out.println("1. Add a subject");
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
     * Runs the menu, allowing the user to select options and perform actions.
     */
    public void run() {
        Student student = new Student();
        int option;
        do {
            show();
            option = getOption();
            switch (option) {
                case 1:
                    student.fillSubjects();
                    break;
                case 2:
                    student.saySubjects();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.print("\033[H\033[2J");
        } while (option != 3);
    }
}

/**
 * Main class to run the application.
 */
public class Main {
    /**
     * The main method to start the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
