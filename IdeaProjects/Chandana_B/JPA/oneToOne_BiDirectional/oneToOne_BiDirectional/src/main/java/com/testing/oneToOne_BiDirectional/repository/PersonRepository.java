package com.testing.oneToOne_BiDirectional.repository;

import com.testing.oneToOne_BiDirectional.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
