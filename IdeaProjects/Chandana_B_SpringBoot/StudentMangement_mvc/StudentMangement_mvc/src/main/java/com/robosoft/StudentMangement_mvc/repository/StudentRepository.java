package com.robosoft.StudentMangement_mvc.repository;

import com.robosoft.StudentMangement_mvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{

}
