package com.biat.msscbreweryservice.events;


import com.biat.msscbreweryservice.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -544654654646L;
    private final BeerDto beerDto;

}
