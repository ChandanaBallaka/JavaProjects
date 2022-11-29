package com.testing.oneToOne_BiDirectional.repository;

import com.testing.oneToOne_BiDirectional.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{

}
