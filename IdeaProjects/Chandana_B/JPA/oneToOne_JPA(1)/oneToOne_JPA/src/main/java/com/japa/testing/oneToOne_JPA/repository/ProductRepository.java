package com.japa.testing.oneToOne_JPA.repository;

import com.japa.testing.oneToOne_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

   // @Query("select p from product p where p.name =:pro")
    //Product findByName(@Param("pro") String name);
   Product findByName( String name);
}
