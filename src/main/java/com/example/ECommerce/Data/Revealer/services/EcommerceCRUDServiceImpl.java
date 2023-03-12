package com.example.ECommerce.Data.Revealer.services;

import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import com.example.ECommerce.Data.Revealer.repository.EcommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EcommerceCRUDServiceImpl implements EcommerceCRUDService {

    private EcommerceRepository ecommerceRepository;

    @Autowired
    public EcommerceCRUDServiceImpl(EcommerceRepository ecommerceRepository) {
        this.ecommerceRepository = ecommerceRepository;
    }

    @Override
    public List<EcommerceTransaction> getAllEcommerceData() {
        List<EcommerceTransaction> ecommerceData = new ArrayList<>();
        Iterable<EcommerceTransaction> ecommerceDataIterable = ecommerceRepository.findAll();
        ecommerceDataIterable.forEach(ecommerceData::add);
        return ecommerceData;
    }

    @Override
    public EcommerceTransaction getEcommerceDataById(String id) {
        return ecommerceRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Data with the given id is not found"));
    }

    @Override
    public EcommerceTransaction saveEcommerceData(EcommerceTransaction ecommerceData) {
        return ecommerceRepository.save(ecommerceData);
    }

    @Override
    public EcommerceTransaction updateEcommerceDate(String id, EcommerceTransaction updatedEcommerceData) {
        EcommerceTransaction ecommerceData = ecommerceRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Data with the id is not present")
        );

        ecommerceData.setCountry(updatedEcommerceData.getCountry());
        ecommerceData.setDescription(updatedEcommerceData.getDescription());
        ecommerceData.setInvoiceDate(updatedEcommerceData.getInvoiceDate());
        ecommerceData.setQuantity(updatedEcommerceData.getQuantity());
        ecommerceData.setInvoiceNo(updatedEcommerceData.getInvoiceNo());
        ecommerceData.setStockCode(updatedEcommerceData.getStockCode());
        ecommerceData.setUnitPrice(updatedEcommerceData.getUnitPrice());
        ecommerceData.setCustomerID(updatedEcommerceData.getCustomerID());

        return ecommerceRepository.save(ecommerceData);
    }

    @Override
    public void deleteEcommerceData(String id) {
        ecommerceRepository.deleteById(id);
    }
}