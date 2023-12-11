package com.csu.cs.week12.models;

public class ServiceProvider {

    private Long id;
    private Long serviceId;
    private String providerName;
    private String serviceName;
    private String price;

    public ServiceProvider() {
    }

    public ServiceProvider(Long id, Long serviceId, String providerName, String serviceName, String price) {
        this.id = id;
        this.serviceId = serviceId;
        this.providerName = providerName;
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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", providerName='" + providerName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
