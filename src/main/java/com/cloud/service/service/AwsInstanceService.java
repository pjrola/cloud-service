package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.domain.Provider;
import org.springframework.stereotype.Service;

@Service(Provider.TypeConstants.AWS)
public class AwsInstanceService implements InstanceAdapterService {

    public Instance create(Instance request) {
        //aws related code
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
