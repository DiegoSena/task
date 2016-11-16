package com.fexco.address.config;

import com.fexco.address.service.AddressAPIService;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denize on 15/11/2016.
 */
@Configuration
public class AddressConfig {

    @Value("${address.url}")
    private String apiUrl;

    @Value("${apikey}")
    private String apiKey;

    @Value("${address.http.maxConnectionsPerHost}")
    private Integer maxConnectionsPerHost;

    @Value("${address.http.maxTotalConnections}")
    private Integer maxTotalConnections;

    @Value("${address.http.connectionTimeout}")
    private Integer connectionTimeout;

    @Value("${address.http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;

    @Value("${address.http.soTimeout}")
    private Integer soTimeout;

    @Bean
    public AddressAPIService addressAPIService() {
        return new AddressAPIService(createHttpClient(), apiUrl);
    }

    private HttpClient createHttpClient() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(soTimeout)
                .build();
        return HttpClientBuilder.create()
                .setMaxConnPerRoute(maxConnectionsPerHost)
                .setMaxConnTotal(maxTotalConnections)
                .setDefaultRequestConfig(config)
                .build();
    }
}
