package com.biat.msscbreweryservice.mappers;

import com.biat.msscbreweryservice.domain.Beer;
import com.biat.msscbreweryservice.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
