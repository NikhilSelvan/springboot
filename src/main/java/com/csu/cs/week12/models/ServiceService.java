package com.csu.cs.week12.models;

import com.csu.cs.week12.Week12Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository, UserRepository userRepository){
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
    }
    public List<ServiceInfo> getServices() {
       return serviceRepository.findAll();
    }

    public List<ServiceProvider> getServiceProviders(Boolean isProvider) {

        List<ServiceProvider> serviceProviders = new ArrayList<ServiceProvider>();

        if (!isProvider) {
            List<ServiceInfo> serviceInfos = serviceRepository.findAll();
            for (ServiceInfo serviceInfo : serviceInfos) {
                ServiceProvider serviceProvider = new ServiceProvider();
                UserInfo userInfo = userRepository.findUserInfoById(serviceInfo.getId());
                serviceProvider.setId(serviceInfo.getId());
                serviceProvider.setProviderName(userInfo.getName());
                serviceProvider.setServiceName(serviceInfo.getServiceName());
                serviceProvider.setPrice("$" + serviceInfo.getPrice());

                serviceProviders.add(serviceProvider);
            }
        } else {
            Long userId = Long.parseLong(Week12Application.defaultProperties.getProperty("id"));
            List<ServiceInfo> serviceInfos = serviceRepository.findMyServices(userId);
            for (ServiceInfo serviceInfo : serviceInfos) {
                ServiceProvider serviceProvider = new ServiceProvider();
                UserInfo userInfo = userRepository.findUserInfoById(serviceInfo.getId());
                serviceProvider.setId(serviceInfo.getId());
                serviceProvider.setProviderName(userInfo.getName());
                serviceProvider.setServiceName(serviceInfo.getServiceName());
                serviceProvider.setPrice("$" + serviceInfo.getPrice());

                serviceProviders.add(serviceProvider);
            }
        }

        return serviceProviders;

    }



/*
    public void addNewService(ServiceInfo ServiceInfo) {
        ServiceInfo ServiceByPhoneNumber = ServiceRepository
                .findServiceInfoByPhoneNumber(ServiceInfo.getPhoneNumber());
        if (ServiceByPhoneNumber != null){
            throw new IllegalStateException("phone already used");
        }
        ServiceRepository.save(ServiceInfo);
        System.out.println("new Service has been inserted successfully");
    }

    public void deleteService(Long ServiceId) {
               boolean exists = ServiceRepository.existsById(ServiceId);
                if (!exists) {
                    throw new IllegalStateException("Service with id" + ServiceId + " does not exist");
                }
                ServiceRepository.deleteById(ServiceId);
    }

    public ServiceInfo findServiceInfoByPhoneNumber(String phoneNumber) {
        ServiceInfo ServiceInfo = ServiceRepository.findServiceInfoByPhoneNumber(phoneNumber);
        if (ServiceInfo == null) {
            System.out.println("No Service found");
            return null;
        } else {
            System.out.println("Service already exists");
            return ServiceInfo;
        }

    }

    public ServiceInfo findServiceInfoByPhoneNumberAndPassword(String phoneNumber, String password){
        ServiceInfo ServiceInfo = ServiceRepository.findServiceInfoByPhoneNumberAndPassword(phoneNumber, password);
        if (ServiceInfo == null) {
            System.out.println("No Service found");
            return null;
        } else {
            System.out.println("Service already exists");
            return ServiceInfo;
        }
    }
*/
    public void saveService(ServiceInfo serviceInfo) {
        serviceRepository.save(serviceInfo);
    }

    public void addNewService(ServiceInfo serviceInfo) {
        serviceRepository.save(serviceInfo);
        /*serviceRepository.saveService(serviceInfo.getId(),
                serviceInfo.getServiceName(),
                serviceInfo.getPrice());
        */
    }
}