package pro.sky.mockito.teststudents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private Map<Integer, Student> allStudents = new HashMap<>();
    private static int countId = 1;
    private StudentValueGenerator studentValueGenerator;

    public University(StudentValueGenerator studentValueGenerator) {
        this.studentValueGenerator = studentValueGenerator;
    }

    public void addStudent(Student student) {
        student.setId(countId);
        student.setAge(studentValueGenerator.generateAge());
        allStudents.put(countId, student);
        countId++;
    }

    public void addStudentInRange(Student student, int minYear, int maxYear) {
        if (student.getAge() > minYear && student.getAge() < maxYear) {
            addStudent(student);
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student> (allStudents.values());
    }


}
