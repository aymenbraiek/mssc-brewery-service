package com.biat.msscbreweryservice.Boostrap;

import com.biat.msscbreweryservice.Repository.BeerRepository;
import com.biat.msscbreweryservice.domain.Beer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {
    private  final BeerRepository beerRepository;
    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";



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
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal(12.9))
                    .minOnhand(12)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("beer2")
                    .beerStyle("style2")
                    .quantityOnHand(250)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal(19.9))
                    .minOnhand(11)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("beer3")
                    .beerStyle("style3")
                    .quantityOnHand(255)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal(20.9))
                    .minOnhand(111)
                    .build());
        }
        System.out.println("beer load" + beerRepository.count());

    }


}
