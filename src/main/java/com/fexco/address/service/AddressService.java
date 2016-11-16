package com.fexco.address.service;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.repository.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public List<Address> getAddresses(String country, String query, OptionalParameters optionalParameters) {
        return addressDAO.getAddresses(country, query, optionalParameters);
    }
}
