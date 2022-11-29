package com.japa.robosoft.oneToMany_JPA.repository;

import com.japa.robosoft.oneToMany_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
