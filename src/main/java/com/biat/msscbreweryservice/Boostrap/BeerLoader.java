package com.biat.msscbreweryservice.Boostrap;

import com.biat.msscbreweryservice.Repository.BeerRepository;
import com.biat.msscbreweryservice.domain.Beer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("beer1")
                    .beerStyle("style1")
                    .quantityOnHand(200)
                    .upc(665565656L)
                    .price(new BigDecimal(12.9))
                    .minOnhand(12)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("beer2")
                    .beerStyle("style2")
                    .quantityOnHand(250)
                    .upc(665565656000L)
                    .price(new BigDecimal(19.9))
                    .minOnhand(11)
                    .build());
        }
        System.out.println("beer load" + beerRepository.count());
        //System.out.println("beer load"+beerRepository.count());
    }


}
