package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Course;
import com.ramon.jpademo.entity.Guardian;
import com.ramon.jpademo.entity.Student;
import com.ramon.jpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Abel")
                .lastName("Ramirez")
                .build();

        Course course = Course.builder()
                .title("Web Design")
                .credit(60)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    void findAllPagination() {

        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("courses = " + courses);

        int pages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("pages = " + pages);

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println("totalElements = " + totalElements);
    }

    @Test
    void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    void findTitleContainig() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("A", firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
        
    }

    @Test
    void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Francisco")
                .lastName("Gutierrez")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Superman")
                .email("superman@gmail.com")
                .mobile("3312232425")
                .build();

        Student student = Student.builder()
                .emailId("rapmon@gmail.com")
                .firstName("Raymond")
                .lastName("Locote")
                .guardian(guardian)
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}