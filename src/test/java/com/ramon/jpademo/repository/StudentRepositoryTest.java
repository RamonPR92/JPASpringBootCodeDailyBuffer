package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Guardian;
import com.ramon.jpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ramon@hotmail.com")
                .firstName("Ramon")
                .lastName("Perez")
//            .guardianName("Guardian")
//            .guardianEmail("guardian@hotmail.com")
//            .guardianMobile("3334556677")
                .build();
        studentRepository.save(student);
    }

    @Test
    void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Pedro")
                .email("pedro@gmail.com")
                .mobile("3317572094")
                .build();

        Student student = Student.builder()
                .firstName("Juan")
                .lastName("Ruiz")
                .emailId("juan@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Ramon");
        System.out.println(students);
    }

    @Test
    void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("ua");
        System.out.println(students);
    }

    @Test
    void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Pedro");
        System.out.println(students);
    }

    @Test
    void printStudentByEmail() {
        Student student = studentRepository.getStudentsByEmailId("ramon@hotmail.com");
        System.out.println("student = " + student);
    }

    @Test
    void printStudentByEmailNativeQuery() {
        Student student = studentRepository.getStudentsByEmailIdNative("ramon@hotmail.com");
        System.out.println("student = " + student);
    }

    @Test
    void printStudentByEmailNativeQueryNamedParams() {
        Student student = studentRepository.getStudentsByEmailIdNativeNamedParams("ramon@hotmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    void printUpdateUserFirstNameById() {
        int result = studentRepository.updateStudentNameByEmailId("Pancho", "juan@gmail.com");
        System.out.println("result = " + result);
    }
}