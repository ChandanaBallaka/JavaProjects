package com.japa.robosoft.oneToMany_JPA.repository;

import com.japa.robosoft.oneToMany_JPA.dto.OrderResponse;
import com.japa.robosoft.oneToMany_JPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {   //here firstentry is customer and integer is the datatype of primarykey.

    @Query("SELECT new com.japa.robosoft.oneToMany_JPA.dto.OrderResponse (c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
