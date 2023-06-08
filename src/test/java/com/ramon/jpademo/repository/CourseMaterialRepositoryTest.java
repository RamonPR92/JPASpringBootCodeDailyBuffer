package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Course;
import com.ramon.jpademo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void saveCourseMaterial() {

        Course course = Course.builder()
                .title("Amazon Web Services")
                .credit(60)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.amazon/courses.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void printAllCoursesMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}