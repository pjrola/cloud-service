package com.cloud.service.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {

    @Value("${cloud.aws.credentials.accessKeyId}")
    private String accessKeyId;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.credentials.region}")
    private String region;

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, secretKey));
    }

    @Bean
    public AmazonCloudFormation amazonCloudFormationClient(AWSCredentialsProvider awsCredentials) {
        return AmazonCloudFormationClientBuilder.standard()
                .withCredentials(awsCredentials)
                .withRegion(region)
                .build();
    }
}