package com.biat.msscbreweryservice.Controller;

import com.biat.msscbreweryservice.model.BeerDto;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public  @ResponseBody ResponseEntity createNewBeer(@RequestBody  @Validated  BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping({"/{beerId}"})
    public @ResponseBody ResponseEntity  updateBeerById(@PathVariable("beerId") UUID beerId,@RequestBody  @Validated BeerDto beerDto)
    {

        return  new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}
