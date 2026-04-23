import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    // ── ADD ──────────────────────────────────────────────
    public void addStudent(String name, int age, String course) {
        students.add(new Student(nextId++, name, age, course));
        System.out.println("✅ Student added successfully!");
    }

    // ── DISPLAY ALL ──────────────────────────────────────
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("⚠️  No students found.");
            return;
        }
        String line = "+------+----------------------+-----+----------------------+";
        System.out.println(line);
        System.out.printf("| %-4s | %-20s | %-3s | %-20s |%n", "ID", "Name", "Age", "Course");
        System.out.println(line);
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println(line);
        System.out.println("Total students: " + students.size());
    }

    // ── DELETE ───────────────────────────────────────────
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("🗑️  Student with ID " + id + " deleted.");
        } else {
            System.out.println("❌ No student found with ID " + id + ".");
        }
    }
}
