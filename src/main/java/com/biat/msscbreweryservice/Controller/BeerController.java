package com.biat.msscbreweryservice.Controller;

import com.biat.msscbreweryservice.model.BeerDto;
import com.biat.msscbreweryservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    @GetMapping("/{beerId}")
    public BeerDto getBeerById(@PathVariable("beerId") UUID beerId) {

        return beerService.getById(beerId);
    }

    @PostMapping
    public @ResponseBody
    BeerDto createNewBeer(@RequestBody @Validated BeerDto beerDto) {
        return beerService.saveBeer(beerDto);
    }

    @PutMapping({"/{beerId}"})
    public @ResponseBody
    BeerDto updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {

        return beerService.updateBeer(beerId, beerDto);

    }


}
