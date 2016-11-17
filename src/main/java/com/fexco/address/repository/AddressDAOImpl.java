package com.fexco.address.repository;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.service.AddressAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private AddressAPIService addressAPIService;

    @Override
    public List<Address> getAddresses(String country, String query, OptionalParameters optionalParameters) {
        return addressAPIService.getAddresses(country, query, optionalParameters);
    }

    public void setAddressAPIService(AddressAPIService addressAPIService) {
        this.addressAPIService = addressAPIService;
    }
}
