package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
