package com.cloud.service.service;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.cloud.service.domain.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("aws")
public class AwsInstanceService implements InstanceAdapterService {

    private AmazonCloudFormation cloudFormation;

    @Autowired
    public AwsInstanceService(AmazonCloudFormation stackBuilder) {
        this.cloudFormation = stackBuilder;
    }

    public Instance create(Instance request) {
        return null;
    }

    public Instance update(Instance request) {
        return null;
    }

    public void delete(Instance request) {

    }

    public Instance find(String remoteId) {
        return null;
    }
}