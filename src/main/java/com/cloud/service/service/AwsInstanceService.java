package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import org.springframework.stereotype.Service;

@Service("amazon")
public class AwsInstanceService implements InstanceAdapterService<Instance> {
    public void process(Instance request) {
        System.out.println("AWS Processing Provider " + request.getName());
    }
}
