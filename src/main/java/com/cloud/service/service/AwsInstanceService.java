package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.domain.Provider;
import org.springframework.stereotype.Service;

@Service(Provider.TypeConstants.AWS)
public class AwsInstanceService implements InstanceAdapterService {
    public Instance process(Instance request) {
        return request;
    }
}
