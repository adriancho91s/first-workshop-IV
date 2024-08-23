import java.util.ArrayList;
import java.util.Scanner;

interface ISubject {
    String getName();
    double calculateAverage();
    boolean isPassed();
    void addGrades(double[] grades);
    void showSubjectResult();
}

class Subject implements ISubject {
    private String name;
    private double[] grades = new double[4];

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addGrades(double[] grades) {
        this.grades = grades;
    }

    @Override
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    @Override
    public boolean isPassed() {
        return calculateAverage() >= 3;
    }

    @Override
    public void showSubjectResult() {
        double average = calculateAverage();
        System.out.printf("%s – average: %.2f – %s\n", name, average, isPassed() ? "passed subject" : "failed subject");
    }
}

class Student {
    private final ArrayList<ISubject> subjects;

    public Student() {
        subjects = new ArrayList<>();
    }

    public void addSubject(ISubject subject) {
        subjects.add(subject);
    }

    public void fillSubjects() {
        Scanner scanner = new Scanner(System.in);
        String name;

        do {
            System.out.println("Enter the name of the subject:");
            name = scanner.nextLine();
            ISubject subject = new Subject(name);
            double[] grades = new double[4];
            for (int i = 0; i < 4; i++) {
                System.out.printf("Enter grade %d for %s:\n", i + 1, name);
                grades[i] = scanner.nextDouble();
            }
            scanner.nextLine();
            subject.addGrades(grades);
            addSubject(subject);
            System.out.println("Press enter to add another subject or type 'exit' to finish");
            name = scanner.nextLine();
        } while (!name.equalsIgnoreCase("exit"));
    }

    public void showResults() {
        double totalAverage = 0;
        for (ISubject subject : subjects) {
            subject.showSubjectResult();
            totalAverage += subject.calculateAverage();
        }
        totalAverage /= subjects.size();
        System.out.printf("Overall Average: %.2f – %s\n", totalAverage, getSemesterResult(totalAverage));
    }

    private String getSemesterResult(double average) {
        if (average < 3) {
            return "Failed semester";
        } else if (average >= 3 && average < 4) {
            return "Regular semester";
        } else {
            return "Congratulations! You qualify for a scholarship.";
        }
    }
}

class Menu {
    public void show() {
        System.out.println("1. Add a subject");
        System.out.println("2. Display results");
        System.out.println("3. Exit");
    }

    int getOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        int option;
        do {
            show();
            option = getOption();
            scanner.nextLine();
            switch (option) {
                case 1:
                    student.fillSubjects();
                    break;
                case 2:
                    student.showResults();
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
