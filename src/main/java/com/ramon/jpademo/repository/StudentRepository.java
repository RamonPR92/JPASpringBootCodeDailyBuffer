package com.ramon.jpademo.repository;

import com.ramon.jpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select distinct s from Student  s where s.emailId = ?1")
    Student getStudentsByEmailId(String emailId);

    //Native query
    @Query(
            value = "select * from tbl_student where email_address = ?1",
            nativeQuery = true
    )
    Student getStudentsByEmailIdNative(String emailId);

    //Native Named Param query
    @Query(
            value = "select * from tbl_student where email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentsByEmailIdNativeNamedParams(@Param("emailId") String emailId);

    @Modifying //Is for any method that modify the database like updates or deletes
    @Transactional //Is for enclose the method in a transactional operation, with a commit or rollback if something go bad or good
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
