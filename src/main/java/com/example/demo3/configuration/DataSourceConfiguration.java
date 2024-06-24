package com.example.demo3.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DataSourceConfigurationProperties.class)
public class DataSourceConfiguration {
    private final DataSourceConfigurationProperties properties;

    public DataSourceConfiguration(DataSourceConfigurationProperties properties) {
        this.properties = properties;
    }

    @Bean
    DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(this.properties.getDriverClassName());

        dataSource.setUrl(this.properties.getUrl());
        dataSource.setUsername(this.properties.getUsername());
        dataSource.setPassword(this.properties.getPassword());
        dataSource.setInitialSize(this.properties.getInitialSize());
        dataSource.setMaxIdle(this.properties.getMaxIdle());
        dataSource.setMinIdle(this.properties.getMinIdle());
        return dataSource;
    }
}
