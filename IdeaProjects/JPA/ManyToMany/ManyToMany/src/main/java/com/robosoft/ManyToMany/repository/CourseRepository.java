package com.robosoft.ManyToMany.repository;

import com.robosoft.ManyToMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>
{

}
