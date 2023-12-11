package com.csu.cs.week12.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository
        extends JpaRepository<ServiceInfo, ServiceInfoCombo> {

    @Query("SELECT s FROM ServiceInfo s WHERE s.id =?1")
    ServiceInfo findUserInfoById(Long id);

    @Query("SELECT s FROM ServiceInfo s WHERE s.serviceName =?1")
    ServiceInfo findUserInfoByServiceName(String serviceName);

    @Query("SELECT s FROM ServiceInfo s WHERE s.id =?1")
    List<ServiceInfo> findMyServices(Long id);

    @Query("SELECT s FROM ServiceInfo s")
    List<ServiceInfo> findAll();

    //@Modifying
    @Query(value = "insert into ServiceInfo(id, serviceName, price) VALUES (?1, ?2, ?3)")
    void saveService(Long userId, String serviceName, Double price);


}
