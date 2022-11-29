package com.testing.onetoonebi.repository;

import com.testing.onetoonebi.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
}
