package com.biat.msscbreweryservice.services.inventory;

import com.biat.msscbreweryservice.Boostrap.BeerLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@Disabled // utility for manual testing
@SpringBootTest
public class BeerInventoryServiceRestTemplateImpl{
    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getOnhandInventory() {
        Integer qoh = beerInventoryService.getOnhandInventory(UUID.fromString(BeerLoader.BEER_2_UPC));

        System.out.println(qoh);

    }

}
