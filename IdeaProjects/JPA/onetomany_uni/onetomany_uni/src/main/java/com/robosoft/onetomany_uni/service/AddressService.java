package com.robosoft.onetomany_uni.service;

import com.robosoft.onetomany_uni.modal.Address;
import com.robosoft.onetomany_uni.repository.AddressRepository;
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
