package com.fexco.address.service;

import com.fexco.address.log.LogHelper;
import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import org.apache.http.client.HttpClient;
import retrofit.RestAdapter;
import retrofit.client.ApacheClient;
import retrofit.converter.JacksonConverter;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
public class AddressAPIService {

    private AddressAPI addressAPI;

    public AddressAPIService(HttpClient httpClient, String url){
        addressAPI = new RestAdapter.Builder()
                .setEndpoint(url)
                .setClient(new ApacheClient(httpClient))
                .setConverter(new JacksonConverter())
                .build().create(AddressAPI.class);
    }

    public List<Address> getAddresses(String country, String query, OptionalParameters optionalParameters){
        return addressAPI.getAddresses(country,
                                       query,
                                       optionalParameters.getLines(),
                                       optionalParameters.getInclude(),
                                       optionalParameters.getExclude(),
                                       optionalParameters.getAddtags(),
                                       optionalParameters.getIdentifier(),
                                       optionalParameters.getPage(),
                                       LogHelper.getCurrentTID());
    }

    public List<Address> getAddressGeos(String country, String query, OptionalParameters optionalParameters){
        return addressAPI.getAddressGeos(country,
                query,
                optionalParameters.getLines(),
                optionalParameters.getInclude(),
                optionalParameters.getExclude(),
                optionalParameters.getAddtags(),
                optionalParameters.getIdentifier(),
                optionalParameters.getPage(),
                LogHelper.getCurrentTID());
    }

    public List<Address> getPosition(String country, String query, OptionalParameters optionalParameters) {
        return addressAPI.getPosition(country,
                query,
                optionalParameters.getLines(),
                optionalParameters.getInclude(),
                optionalParameters.getExclude(),
                optionalParameters.getAddtags(),
                optionalParameters.getIdentifier(),
                optionalParameters.getPage(),
                LogHelper.getCurrentTID());
    }


}
