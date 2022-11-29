package com.robosoft.onetomany_uni.repository;

import com.robosoft.onetomany_uni.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>
{
}
