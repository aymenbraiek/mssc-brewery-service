package com.biat.msscbreweryservice.events;


import com.biat.msscbreweryservice.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
