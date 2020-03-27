package com.cloud.service.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instances")
public class Instance extends BaseEntity {

    @NotBlank
    @Column(name = "remote_id", unique = true)
    private String remoteId;

    @NotBlank
    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private InstanceState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private Provider provider;

    public Instance() {}

    public String getRemoteId() {
        return remoteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstanceState getState() {
        return state;
    }

    public void setState(InstanceState state) {
        this.state = state;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}