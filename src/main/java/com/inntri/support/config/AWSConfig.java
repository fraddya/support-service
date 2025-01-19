package com.inntri.support.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AWSConfig {


    @Autowired
    private AppPropertiesConfig propertiesConfig;

    public AWSCredentials credentials() {
        log.info("access key {}", propertiesConfig.getS3().getAccessKey());
        log.info("secret key {}", propertiesConfig.getS3().getSecretKey());
        AWSCredentials credentials = new BasicAWSCredentials(
                propertiesConfig.getS3().getAccessKey(),
                propertiesConfig.getS3().getSecretKey()
        );
        return credentials;
    }

    @Bean
    public AmazonS3 amazonS3() {
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withRegion(Regions.AP_SOUTH_1)
                .build();
        return s3client;
    }

}
