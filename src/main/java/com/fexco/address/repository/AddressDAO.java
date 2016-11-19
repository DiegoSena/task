package com.fexco.address.repository;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
public interface AddressDAO {
    List<Address> getAddresses(String country, String query, OptionalParameters optionalParameters);
    List<Address> getAddressGeos(String country, String query, OptionalParameters optionalParameters);
    List<Address> getPosition(String country, String query, OptionalParameters optionalParameters);
}
