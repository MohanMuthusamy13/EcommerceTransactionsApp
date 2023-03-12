package com.example.ECommerce.Data.Revealer.services;

import co.elastic.clients.util.DateTime;
import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface EcommerceSearchService {

    List<EcommerceTransaction> getEcommerceTransactionsByCountry(String country);
    List<EcommerceTransaction> getEcommerceTransactionsByCustomerID(long customerID);
    long getTransactionsCountByCustomerID(long customerID);
    List<EcommerceTransaction> getTransactionsByContent(String content);
    long getTransactionsCountByDescription(String description);
    List<EcommerceTransaction> getTransactionsByContentAndCountry(String content, String country);

    List<EcommerceTransaction> getTransactions(String content, String country,
                                               DateTime startDate, DateTime endDate);
}