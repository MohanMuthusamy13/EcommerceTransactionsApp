package com.example.ECommerce.Data.Revealer.services;

import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EcommerceCRUDService {
    List<EcommerceTransaction> getAllEcommerceData();
    EcommerceTransaction getEcommerceDataById(String id);
    EcommerceTransaction saveEcommerceData(EcommerceTransaction ecommerceData);
    EcommerceTransaction updateEcommerceDate(String id, EcommerceTransaction ecommerceData);
    void deleteEcommerceData(String id);

}