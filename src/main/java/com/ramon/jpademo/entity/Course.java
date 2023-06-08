package com.ramon.jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    //2  Add One to One and mappedBy with the object name on the other class
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    //When we use @ManyToOne the new column will be created on course table,
    //but we will be referring the teacherId property on Teacher class
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //When we use @ManyToMany, a new table will be created,
    //We must use @JoinTable for create a new table and define the table name,
    //We must define which columns will be referred and which class properties we are doing reference
    //We can define this configuration in one of the two tables that are participating
    @JoinTable(
        name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudent(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
