package com.fexco.address.service;

import com.fexco.address.model.Address;

import java.util.List;

import retrofit.http.*;

/**
 * Created by Denize on 15/11/2016.
 */
public interface AddressAPI {

    @GET("/address/{country}/{query}")
    List<Address> getAddresses(@Path("country") String country,
                               @Path(value = "query") String query,
                               @Query("lines") String lines,
                               @Query("include") String include,
                               @Query("exclude") String exclude,
                               @Query("addtags") String addtags,
                               @Query("identifier") String identifier,
                               @Query("page") String page,
                               @Header("X-TID") String tid);
}
