package com.robosoft.ManyToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course
{
    @Id
    private int courseId;
    private String courseTitle;
    private int no_of_modules;

    @ManyToMany(mappedBy = "courseList", fetch = FetchType.LAZY)
    private List<Student> student;

}
