package com.cloud.service.controller;

import com.cloud.service.annotation.Loggable;
import com.cloud.service.annotation.TrackExecutionTime;
import com.cloud.service.domain.Instance;
import com.cloud.service.exception.ResourceNotFoundException;
import com.cloud.service.service.InstanceDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class InstanceController {

    private final InstanceDatabaseService service;

    @Autowired
    public InstanceController(InstanceDatabaseService service) {
        this.service = service;
    }

    @PostMapping("/instances")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Instance create(@Valid @RequestBody Instance instance) throws ResourceNotFoundException {
        throw new ResourceNotFoundException(instance.getRemoteId());
    }

}
