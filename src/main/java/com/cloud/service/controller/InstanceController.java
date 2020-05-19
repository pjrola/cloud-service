package com.cloud.service.controller;

import com.cloud.service.annotation.Loggable;
import com.cloud.service.annotation.TrackExecutionTime;
import com.cloud.service.domain.Instance;
import com.cloud.service.service.InstanceDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InstanceController {

    private InstanceDatabaseService service;

    @Autowired
    public InstanceController(InstanceDatabaseService service) {
        this.service = service;
    }

    @Loggable
    @PostMapping("/instances")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Instance process(@RequestBody Instance instance) {
        return service.save(instance);
    }

}
