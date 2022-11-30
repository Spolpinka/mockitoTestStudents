package pro.sky.mockito.teststudents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UniversityTest {
    private final Student student = new Student("Вася", true);
    @Mock
    private StudentValueGenerator studentValueGenerator;
    University university;
    @BeforeEach
    private void setUp() {
        university = new University(studentValueGenerator);
    }

    @Test
    public void getAllStudents() {
        assertNotNull(studentValueGenerator);

        Mockito.when(studentValueGenerator.generateAge()).thenReturn(50);

        university.addStudent(student);
        List<Student> expected = university.getAllStudents();
        assertEquals(expected.get(0).getAge(), 50);
    }
}
