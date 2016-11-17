package com.fexco.address.repository;

import com.fexco.address.model.Address;
import com.fexco.address.model.OptionalParameters;
import com.fexco.address.service.AddressAPIService;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Denize on 15/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressDaoImplTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    private static AddressDAOImpl addressDAOImpl = new AddressDAOImpl();

    @BeforeClass
    public static void setUp(){
        AddressAPIService addressAPIService = new AddressAPIService(createHttpClient(), "http://localhost:8089/");
        addressDAOImpl.setAddressAPIService(addressAPIService);
    }

    private static HttpClient createHttpClient() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .build();
        return HttpClientBuilder.create()
                .setMaxConnPerRoute(100)
                .setMaxConnTotal(100)
                .setDefaultRequestConfig(config)
                .build();
    }

    @Test
    public void test_return_address(){
        stubFor(get(urlEqualTo("/address/uk/street"))
                .willReturn(aResponse().
                        withHeader("Content-Type", "application/json").
                        withStatus(HttpStatus.OK.value()).
                        withBody(response())));

        List<Address> addresses = addressDAOImpl.getAddresses("uk", "street", OptionalParameters.builder().build());
        assertEquals(1, addresses.size());
        assertEquals("Allies Computing Ltd, Manor Farm Barns, Fox Road, Framingham Pigot, Norwich, Norfolk, NR14 7PZ", addresses.get(0).getSummaryline());
    }

    private static String response() {
        return "[{\"summaryline\":\"Allies Computing Ltd, Manor Farm Barns, Fox Road, Framingham Pigot, Norwich, Norfolk, NR14 7PZ\",\"organisation\":\"Allies Computing Ltd\",\"buildingname\":\"Manor Farm Barns\",\"premise\":\"Manor Farm Barns\",\"street\":\"Fox Road\",\"dependentlocality\":\"Framingham Pigot\",\"posttown\":\"Norwich\",\"county\":\"Norfolk\",\"postcode\":\"NR14 7PZ\"}]";
    }


}
