package com.biat.msscbreweryservice.services;

import com.biat.msscbreweryservice.domain.Beer;
import com.biat.msscbreweryservice.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
