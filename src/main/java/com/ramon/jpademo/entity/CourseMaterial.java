package com.ramon.jpademo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(
        exclude = "course"
)
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "couse_material_sequence",
            sequenceName = "couse_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "couse_material_sequence"
    )
    private Long courseMaterialId;

    private String url;

    //CourseMaterial cannot exist if there not is a Course
    //Bidirectional One to One
    //@JoinColumn creates a foreign key and a column named course_id
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false//The course must define the course if not it cant be created
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
