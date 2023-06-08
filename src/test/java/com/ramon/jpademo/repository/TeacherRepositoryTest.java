package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Course;
import com.ramon.jpademo.entity.CourseMaterial;
import com.ramon.jpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {

        Course coursetypeScript = Course.builder()
                .title("Typescript")
                .credit(60)
                .build();

        Course courseAngular = Course.builder()
                .title("Angular")
                .credit(60)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ramon")
                .lastName("Perez")
                //.courses(List.of(coursetypeScript, courseAngular))
                .build();

        teacherRepository.save(teacher);
    }
}