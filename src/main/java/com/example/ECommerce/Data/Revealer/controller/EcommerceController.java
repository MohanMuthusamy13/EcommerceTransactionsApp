package com.example.ECommerce.Data.Revealer.controller;

import com.example.ECommerce.Data.Revealer.entities.EcommerceTransaction;
import com.example.ECommerce.Data.Revealer.services.EcommerceCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerceData")
public class EcommerceController {

    private EcommerceCRUDService ecommerceService;

    public EcommerceController(EcommerceCRUDService ecommerceService) {
        this.ecommerceService = ecommerceService;
    }

    @GetMapping
    public ResponseEntity<List<EcommerceTransaction>> getAllEcommerceData() {
        return new ResponseEntity<>(ecommerceService.getAllEcommerceData(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcommerceTransaction> getEcommerceDataById(
            @PathVariable(value = "id") String id
    ) {
        return new ResponseEntity<>(ecommerceService.getEcommerceDataById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EcommerceTransaction> createEcommerceData(
            @RequestBody EcommerceTransaction ecommerceData
    ) {
        return new ResponseEntity<>(ecommerceService.saveEcommerceData(ecommerceData),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcommerceTransaction> updateEcommerceData(
            @PathVariable(value = "id") String id,
            @RequestBody EcommerceTransaction ecommerceData
    ) {
        return new ResponseEntity<>(ecommerceService.updateEcommerceDate(id, ecommerceData),
                HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteEcommerceData(
            @RequestParam(value = "id") String id
    ) {
        ecommerceService.deleteEcommerceData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}