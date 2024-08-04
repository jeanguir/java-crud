import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDatabase {
    private List<Student> students;
    private int nextId;

    public StudentDatabase() {
        students = new ArrayList<>();
        nextId = 1;
    }

    public void addStudent(String name, int age, String major) {
        students.add(new Student(nextId++, name, age, major));
    }

    public Optional<Student> getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public boolean updateStudent(int id, String name, int age, String major) {
        Optional<Student> optionalStudent = getStudent(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            student.setAge(age);
            student.setMajor(major);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}
