package com.csu.cs.week12.models;

import jakarta.persistence.*;

@Entity
@Table
public class ServiceInfo {

    @Id
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
    private Long id;
    private String serviceName;
    private Double price;

    public ServiceInfo() {
    }

    public ServiceInfo(Long id, Long serviceId, String serviceName, Double price) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
