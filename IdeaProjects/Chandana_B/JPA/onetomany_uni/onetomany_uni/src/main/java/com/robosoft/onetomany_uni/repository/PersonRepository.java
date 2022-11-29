package com.robosoft.onetomany_uni.repository;

import com.robosoft.onetomany_uni.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
