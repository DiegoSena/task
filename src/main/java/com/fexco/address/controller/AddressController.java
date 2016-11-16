package com.fexco.address.controller;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("{country}/{query}")
    public ResponseEntity getAddress(@PathVariable String country, @PathVariable String query, OptionalParameters optionalParameters){
        List<Address> addresses = addressService.getAddresses(country, query, optionalParameters);
        return new ResponseEntity(addresses, HttpStatus.OK);
    }
}
