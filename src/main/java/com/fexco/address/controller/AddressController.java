package com.fexco.address.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.service.AddressService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Denize on 15/11/2016.
 */
@RestController
public class AddressController {

    private static final Log LOG = LogFactory.getLog(AddressController.class);
    public static final String IE = "ie";

    @Autowired
    private AddressService addressService;

    @RequestMapping("address/{country}/{query}")
    public Object getAddress(@PathVariable String country, @PathVariable String query, OptionalParameters optionalParameters){
        MDC.put("country", country);
        MDC.put("query", query);
        LOG.info("Address request received. Country: " + country + ", Query: " + query + ", parameters: " + optionalParameters);

        List<Address> addresses = addressService.getAddresses(country, query, optionalParameters);
        if(optionalParameters != null && StringUtils.isNotBlank(optionalParameters.getCallback())){
            return new JSONPObject(optionalParameters.getCallback(), addresses);
        }
        return addresses;
    }

    @RequestMapping("addressgeo/ie/{query}")
    public Object getAddressGeo(@PathVariable String query, OptionalParameters optionalParameters){
        MDC.put("country", IE);
        MDC.put("query", query);
        LOG.info("Addressgeo request received. Country: " + IE + ", Query: " + query + ", parameters: " + optionalParameters);

        List<Address> addresses = addressService.getAddressGeos(IE, query, optionalParameters);
        if(optionalParameters != null && StringUtils.isNotBlank(optionalParameters.getCallback())){
            return new JSONPObject(optionalParameters.getCallback(), addresses);
        }
        return addresses;
    }

    @RequestMapping("position/ie/{query}")
    public Object getPosition(@PathVariable String query, OptionalParameters optionalParameters){
        MDC.put("country", IE);
        MDC.put("query", query);
        LOG.info("Position request received. Country: " + IE + ", Query: " + query + ", parameters: " + optionalParameters);

        List<Address> addresses = addressService.getPosition(IE, query, optionalParameters);
        if(optionalParameters != null && StringUtils.isNotBlank(optionalParameters.getCallback())){
            return new JSONPObject(optionalParameters.getCallback(), addresses);
        }
        return addresses;
    }
}
