package com.fexco.address.service;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.repository.AddressDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denize on 15/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressDAO addressDAO;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void test_return_address(){
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setSummaryline("summaryline");
        addresses.add(address);
        when(addressDAO.getAddresses(anyString(), anyString(), any(OptionalParameters.class))).thenReturn(addresses);
        List<Address> addressList = addressService.getAddresses("uk", "street", null);
        assertEquals(1, addressList.size() );
        assertEquals("summaryline", addressList.get(0).getSummaryline());
    }
}
