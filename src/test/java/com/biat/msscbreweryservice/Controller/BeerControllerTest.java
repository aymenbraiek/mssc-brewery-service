package com.biat.msscbreweryservice.Controller;


import com.biat.msscbreweryservice.model.BeerDto;
import com.biat.msscbreweryservice.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.math.BigDecimal;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()
        ).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void createNewBeer() throws Exception {
        BeerDto beerDto = getValiderBeerDto();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
               .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content(beerDtoJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        BeerDto beerDto = getValiderBeerDto();

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)
                .contentType("application/json")
                .content((beerDtoJson)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    BeerDto getValiderBeerDto() {
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .prive(new BigDecimal("2.99"))
                .upc(4848484L)
                .build();
    }


}