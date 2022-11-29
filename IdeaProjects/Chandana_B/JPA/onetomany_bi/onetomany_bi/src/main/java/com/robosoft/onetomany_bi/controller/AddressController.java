package com.robosoft.onetomany_bi.controller;

import com.robosoft.onetomany_bi.modal.Address;
import com.robosoft.onetomany_bi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController
{
    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody Address address)
    {
        return addressService.addAddress(address);
    }

    @GetMapping("/addresses")
    public List<Address> viewAllAddress()
    {
        return addressService.viewAllAddress();
    }
}
