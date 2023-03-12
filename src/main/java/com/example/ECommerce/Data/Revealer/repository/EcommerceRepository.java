package com.example.ECommerce.Data.Revealer.repository;

import co.elastic.clients.util.DateTime;
import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcommerceRepository extends ElasticsearchRepository<EcommerceTransaction, String> {

    @Query(value = """
            {
                "wildcard": {
                  "Country": {
                    "value": "*?0*"
                  }
                }
              }""")
    List<EcommerceTransaction> getEcommerceTransactionsByCountry(String country);


    @Query("""
            {
                "match": {
                  "CustomerID": ?0
                }
            }""")
    List<EcommerceTransaction> getEcommerceTransactionsByCustomerID(long customerID);

    @Query(value = """
            {
                "match": {
                  "CustomerID": ?0
                }
            }""", count = true)
    long getTransactionsCountByCustomerID(long customerID);


    @Query(value = """
            {
                "wildcard": {
                  "Description": {
                    "value": "*?0*"
                  }
                }
              }""")
    List<EcommerceTransaction> getTransactionsByContent(String content);

    @Query(value = """
            {
                "match": {
                  "Description": "?0"
                }
            }""", count = true)
    long getTransactionsCountByDescription(String description);


    @Query("""
            {
                "bool": {
                  "must": [
                    {
                      "wildcard": {
                        "Description": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ],
                  "should": [
                    {
                      "wildcard": {
                        "Country": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ]
                }
              }""")
    List<EcommerceTransaction> getTransactionsByContentAndCountry(String content, String country);

    @Query("""
            {
                "bool": {
                  "must": [
                    {
                      "wildcard": {
                        "Description": {
                          "value": "*?0*"
                        }
                      }
                    }
                  ],
                  "should": [
                    {
                      "wildcard": {
                        "Country": {
                          "value": "*?1*"
                        }
                      }
                    }
                  ],
                  "filter": [
                    {
                      "range": {
                        "InvoiceDate": {
                          "gte": "?2",
                          "lte": "?3"
                        }
                      }
                    }
                  ]
                }
              }""")
    List<EcommerceTransaction> getTransactions(String content, String country,
                                               DateTime startDate, DateTime endDate);

}