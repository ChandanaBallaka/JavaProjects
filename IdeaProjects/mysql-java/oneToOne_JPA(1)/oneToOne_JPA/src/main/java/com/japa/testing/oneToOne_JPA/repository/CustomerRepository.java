package com.japa.testing.oneToOne_JPA.repository;

import com.japa.testing.oneToOne_JPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
}