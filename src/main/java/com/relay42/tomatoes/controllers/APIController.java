package com.relay42.tomatoes.controllers;

import com.relay42.tomatoes.domain.TomatoSale;
import com.relay42.tomatoes.services.TomatoSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class APIController {

    private final TomatoSaleService tomatoSaleService;

    @Autowired
    public APIController(TomatoSaleService tomatoSaleService) {
        this.tomatoSaleService = tomatoSaleService;
    }


    @RequestMapping(value = "/data")
    public ArrayList<TomatoSale> getSales(@RequestParam(value = "size", defaultValue = "3") int size) {
        return this.tomatoSaleService.getSales(size);
    }
}
