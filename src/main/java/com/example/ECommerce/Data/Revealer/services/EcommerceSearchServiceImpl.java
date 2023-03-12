package com.example.ECommerce.Data.Revealer.services;

import co.elastic.clients.util.DateTime;
import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import com.example.ECommerce.Data.Revealer.repository.EcommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EcommerceSearchServiceImpl implements EcommerceSearchService {

    private EcommerceRepository ecommerceRepository;

    @Autowired
    public EcommerceSearchServiceImpl(EcommerceRepository ecommerceRepository) {
        this.ecommerceRepository = ecommerceRepository;
    }

    @Override
    public List<EcommerceTransaction> getEcommerceTransactionsByCountry(String country) {
        return ecommerceRepository.getEcommerceTransactionsByCountry(country);
    }

    @Override
    public List<EcommerceTransaction> getEcommerceTransactionsByCustomerID(long customerID) {
        return ecommerceRepository.getEcommerceTransactionsByCustomerID(customerID);
    }

    @Override
    public long getTransactionsCountByCustomerID(long customerID) {
        return ecommerceRepository.getTransactionsCountByCustomerID(customerID);
    }

    @Override
    public List<EcommerceTransaction> getTransactionsByContent(String content) {
        return ecommerceRepository.getTransactionsByContent(content);
    }

    @Override
    public long getTransactionsCountByDescription(String description) {
        return ecommerceRepository.getTransactionsCountByDescription(description);
    }

    @Override
    public List<EcommerceTransaction> getTransactionsByContentAndCountry(String content, String country) {
        return ecommerceRepository.getTransactionsByContentAndCountry(content, country);
    }

    @Override
    public List<EcommerceTransaction> getTransactions(String content, String country, DateTime startDate, DateTime endDate) {
        return ecommerceRepository.getTransactions(content, country, startDate, endDate);
    }
}