package com.cloud.service.controller;

import com.cloud.service.domain.Instance;
import com.cloud.service.exception.LockedException;
import com.cloud.service.exception.ResourceNotFoundException;
import com.cloud.service.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class InstanceController {

    private InstanceService service;

    @Autowired
    public InstanceController(InstanceService service) {
        this.service = service;
    }

    @PostMapping("/instances")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Instance> create(@Valid @RequestBody Instance instance) {
        return new ResponseEntity<>(service.create(instance), HttpStatus.OK);
    }

    @GetMapping("/instances/{id}")
    public ResponseEntity<Instance> findById(@PathVariable(value = "id") Long instanceId) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.get(instanceId), HttpStatus.OK);
    }

    @GetMapping("/instances/provider/{id}")
    public ResponseEntity<Instance> findByRemoteId(@PathVariable(value = "id") String remoteId) throws ResourceNotFoundException {
        return new ResponseEntity<>(service.get(remoteId), HttpStatus.OK);
    }

    @GetMapping("/instances")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Instance> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/instances/{id}")
    public ResponseEntity<Instance> update(@RequestBody Instance instance, @PathVariable long id) throws ResourceNotFoundException, LockedException {
        return new ResponseEntity<>(service.update(id, instance), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/instances/{id}")
    public void delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        service.delete(id);
    }

}
