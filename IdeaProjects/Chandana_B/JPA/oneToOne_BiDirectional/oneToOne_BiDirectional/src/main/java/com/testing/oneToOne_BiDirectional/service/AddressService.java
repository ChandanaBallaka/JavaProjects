package com.testing.oneToOne_BiDirectional.service;

import com.testing.oneToOne_BiDirectional.modal.Address;
import com.testing.oneToOne_BiDirectional.modal.Person;
import com.testing.oneToOne_BiDirectional.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address)
    {
        return addressRepository.save(address);
    }

    public List<Address> viewAllAddress()
    {
        return addressRepository.findAll();
    }
}
