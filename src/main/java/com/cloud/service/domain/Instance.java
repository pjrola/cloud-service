package com.cloud.service.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@ToString
@Table(name = "instances")
public class Instance extends BaseEntity {

    @NotBlank(message = "{instance.name.notBlank}")
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank(message = "{instance.remoteId.notBlank}")
    @Column(name = "remote_id", unique = true, updatable = false)
    private String remoteId;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private InstanceState state;

    @NotBlank(message = "{instance.url.notBlank}")
    @Column(name = "url", unique = true)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private Provider provider;

    @NotBlank(message = "{instance.region.notBlank}")
    @Column(name = "region")
    private String region;

    @Column(name = "locked")
    private boolean locked = false;

    public Instance() {}

    public Instance(String remoteId, String name, InstanceState state, String url, Provider provider, String region, Boolean locked) {
        this.name = name;
        this.remoteId = remoteId;
        this.state = state;
        this.provider = provider;
        this.locked = locked;
        this.url = url;
        this.region = region;
    }
}