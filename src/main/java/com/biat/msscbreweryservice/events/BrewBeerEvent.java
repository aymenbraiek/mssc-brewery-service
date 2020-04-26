package com.biat.msscbreweryservice.events;


import com.biat.msscbreweryservice.model.BeerDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent
{
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
