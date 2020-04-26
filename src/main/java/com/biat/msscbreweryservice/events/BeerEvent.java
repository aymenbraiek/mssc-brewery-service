package com.biat.msscbreweryservice.events;


import com.biat.msscbreweryservice.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {
    static final long serialVersionUID = -544654654646L;
    private  BeerDto beerDto;

}
