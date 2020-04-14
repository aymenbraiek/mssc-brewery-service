package com.biat.msscbreweryservice.services;
import com.biat.msscbreweryservice.model.BeerDto;
import com.biat.msscbreweryservice.model.BeerPageList;
import com.biat.msscbreweryservice.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import java.util.UUID;

public interface BeerService {

   BeerDto getById(UUID beerId,Boolean showInventoryOnHand);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPageList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}
