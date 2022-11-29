package com.robosoft.JPA.repository;

import com.robosoft.JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer>  //here integer is datatype of primary key
{
    Product findByName(String name);
}
