import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.println("==========================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM  v1.0     ");
        System.out.println("==========================================");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Enter a number 1–4.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name   : ");
                    String name = sc.nextLine().trim();

                    System.out.print("Enter Age    : ");
                    int age;
                    try {
                        age = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Age must be a number.");
                        break;
                    }

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine().trim();

                    manager.addStudent(name, age, course);
                }
                case 2 -> manager.displayAll();
                case 3 -> {
                    System.out.print("Enter Student ID to delete: ");
                    int id;
                    try {
                        id = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ ID must be a number.");
                        break;
                    }
                    manager.deleteStudent(id);
                }
                case 4 -> {
                    System.out.println("👋 Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Invalid option. Choose 1–4.");
            }
        }
    }
}
