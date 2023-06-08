package com.ramon.jpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        //we are defining constraints on table level
        uniqueConstraints = @UniqueConstraint(
                name = "email_address_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    //Will be crated a sequence generator that it is going to increment one by one
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    //The value generated will be the before sequence
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false //is like NOT NULL
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}
