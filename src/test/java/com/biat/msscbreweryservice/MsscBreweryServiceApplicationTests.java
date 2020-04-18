package com.biat.msscbreweryservice;

import com.biat.msscbreweryservice.services.inventory.BeerInventoryService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Disabled // utility for manual testing
@SpringBootTest
class MsscBreweryServiceApplicationTests {
    @Autowired
    BeerInventoryService beerInventoryService;

    @Test
    void contextLoads() {

    }

    @Test
    void getOnhandInventory() {

        //todo evolve to use UPC
        //  Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);

        //System.out.println(qoh);

    }
}
