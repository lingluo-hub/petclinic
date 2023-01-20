package com.lingluoyun.petclinic.config;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.configuration.MutableConfiguration;


/**
 * Cache configuration intended for caches providing the JCache API. This configuration
 * creates the used cache for the application and enables statistics that become
 * accessible via JMX.
 */
@EnableCaching
@Configuration(proxyBeanMethods = false)
public class CacheConfiguration {

    @Bean
    public JCacheManagerCustomizer petclinicCacheConfigurationCustomizer() {
        return cacheManager -> cacheManager.createCache("vets", cacheConfiguration());
    }

    private javax.cache.configuration.Configuration<Object, Object> cacheConfiguration() {
        return new MutableConfiguration<>().setStatisticsEnabled(true);
    }


}
