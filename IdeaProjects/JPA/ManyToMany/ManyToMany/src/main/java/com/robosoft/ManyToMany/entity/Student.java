package com.robosoft.ManyToMany.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student
{
    @Id
    @GeneratedValue
    private int stdId;
    private String std_name;
    private int stdAge;
    private String dept;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_tbl",
    joinColumns = {
            @JoinColumn(name = "stdId", referencedColumnName = "stdId")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    })
    private List<Course> courseList;
}
