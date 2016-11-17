package com.fexco.address.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by diego.guimaraes on 17/11/16.
 */
@Configuration
@EnableCaching
public class HazelCastConfig {

    @Value("${hazelcast.endpoint:localhost:5701}")
    private String hazelcastEndpoint;

    @Bean
    public CacheManager cacheManager(){
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress(hazelcastEndpoint);
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
        return new HazelcastCacheManager(client);
    }
}
