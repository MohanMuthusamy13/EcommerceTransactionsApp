package com.example.ECommerce.Data.Revealer.controller;

import co.elastic.clients.util.DateTime;
import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import com.example.ECommerce.Data.Revealer.services.EcommerceSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ecommerceData/getTransactions")
public class EcommerceSearchController {

    private EcommerceSearchService ecommerceSearchService;

    @Autowired
    public EcommerceSearchController(EcommerceSearchService ecommerceSearchService) {
        this.ecommerceSearchService = ecommerceSearchService;
    }

    @GetMapping("/byContent")
    public List<EcommerceTransaction> getTransactionsByContent(
            @RequestParam(value = "content") String content
    ) {
        return ecommerceSearchService.getTransactionsByContent(content);
    }

    @GetMapping("/byCountry")
    public List<EcommerceTransaction> getEcommerceDataByCountry(
            @RequestParam("country") String country
    ) {
        return ecommerceSearchService.getEcommerceTransactionsByCountry(country);
    }

    @GetMapping
    public List<EcommerceTransaction> getEcommerceTransactionsByCustomerID(
            @RequestParam("customerID") long customerID
    ) {
        return ecommerceSearchService.getEcommerceTransactionsByCustomerID(customerID);
    }

    @GetMapping("/count")
    public long getTransactionsCountByCustomerID(
            @RequestParam("customerID") long customerID
    ) {
        return ecommerceSearchService.getTransactionsCountByCustomerID(customerID);
    }

    @GetMapping("/countByDescription")
    public long getTransactionsCountByDescription(
            @RequestParam("description") String description
    ) {
        return ecommerceSearchService.getTransactionsCountByDescription(description);
    }

    @GetMapping("/getContentByCountry")
    public List<EcommerceTransaction> getTransactionsByContentAndCountry(
            @RequestParam(value = "content") String content,
            @RequestParam(value = "country") String country
    ) {
        return ecommerceSearchService.getTransactionsByContentAndCountry(content, country);
    }

    @GetMapping("/ByContentCountryAndDate")
    public List<EcommerceTransaction> getTransactionsByContentAndDate(
            @RequestParam(value = "content") String content,
            @RequestParam(value = "country") String country,
            @RequestParam(value = "date1") DateTime startDate,
            @RequestParam(value = "date2") DateTime endDate
    ) {
        return ecommerceSearchService.getTransactions(content, country, startDate, endDate);
    }


}