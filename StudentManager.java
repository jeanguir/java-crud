import java.util.Scanner;

public class StudentManager {
    private static StudentDatabase studentDatabase = new StudentDatabase();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Add student");
        System.out.println("2. View student");
        System.out.println("3. View all students");
        System.out.println("4. Update student");
        System.out.println("5. Delete student");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        studentDatabase.addStudent(name, age, major);
        System.out.println("Student added successfully.");
    }

    private static void viewStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentDatabase.getStudent(id).ifPresentOrElse(
                student -> System.out.println("Student details: " + student),
                () -> System.out.println("Student not found.")
        );
    }

    private static void viewAllStudents() {
        System.out.println("All students:");
        studentDatabase.getAllStudents().forEach(System.out::println);
    }

    private static void updateStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new major: ");
        String major = scanner.nextLine();
        if (studentDatabase.updateStudent(id, name, age, major)) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (studentDatabase.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
