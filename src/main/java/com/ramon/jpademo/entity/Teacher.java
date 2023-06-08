package com.ramon.jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;

    private String firstName;
    private String lastName;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    //When we use @OneToMany the new column teacher_id will be created on course table,
//    //but we should define on the teacher table
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;
}
