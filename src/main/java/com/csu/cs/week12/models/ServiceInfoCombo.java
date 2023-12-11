package com.csu.cs.week12.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@jakarta.persistence.Embeddable
public class ServiceInfoCombo implements Serializable {

    private Long id;
    @SequenceGenerator(
            name = "service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )
    private Long serviceId;

    public ServiceInfoCombo(Long id, Long serviceId) {
        this.id = id;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}