package com.cloud.service.controller;

import com.cloud.service.domain.Instance;
import com.cloud.service.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InstanceController {

    private ServiceRegistry registry;

    @Autowired
    public InstanceController(ServiceRegistry registry) {
        this.registry = registry;
    }

    @PostMapping("/instances")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void process(@RequestBody Instance instance) {
        registry.getService(instance.getProvider().toString().toLowerCase()).process(instance);
    }

}
