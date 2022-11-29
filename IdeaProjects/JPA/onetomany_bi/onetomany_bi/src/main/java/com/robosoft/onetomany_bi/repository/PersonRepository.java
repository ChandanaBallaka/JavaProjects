package com.robosoft.onetomany_bi.repository;

import com.robosoft.onetomany_bi.modal.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>
{
}
