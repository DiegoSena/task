package com.fexco.address.service;

import com.fexco.address.model.Address;

import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Denize on 15/11/2016.
 */
public interface AddressAPI {

    @GET("/address/{country}/{query}")
    List<Address> getAddresses(@Path("country") String country,
                               @Path("query") String query,
                               @Query("lines") String lines,
                               @Query("include") String include,
                               @Query("exclude") String exclude,
                               @Query("addtags") String addtags,
                               @Query("callback") String callback,
                               @Query("identifier") String identifier,
                               @Query("page") String page);
}
