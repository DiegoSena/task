package com.fexco.address.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Denize on 15/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressControllerTest {

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;


    @Test
    public void test_return_address_without_callback() {
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();
        address.setSummaryline("summaryline");
        addressList.add(address);
        when(addressService.getAddresses(anyString(), anyString(), any(OptionalParameters.class))).thenReturn(addressList);
        List<Address> response = (List<Address>) addressController.getAddress("uk", "street", null);
        assertEquals(1, response.size());
        assertEquals("summaryline", response.get(0).getSummaryline());
    }

    @Test
    public void test_return_address_with_callback(){
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();
        address.setSummaryline("summaryline");
        addressList.add(address);
        when(addressService.getAddresses(anyString(), anyString(), any(OptionalParameters.class))).thenReturn(addressList);
        JSONPObject response = (JSONPObject) addressController.getAddress("uk", "street", OptionalParameters.builder().callback("myfunction").build());
        assertEquals("myfunction", response.getFunction());
        assertEquals(1, ((List<Address>)response.getValue()).size());
        assertEquals("summaryline", ((List<Address>)response.getValue()).get(0).getSummaryline());
    }
}
