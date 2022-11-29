package com.testing.onetoonebi.repository;

import com.testing.onetoonebi.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>
{
}
