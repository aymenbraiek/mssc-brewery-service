package com.biat.msscbreweryservice.services;

import com.biat.msscbreweryservice.Repository.BeerRepository;
import com.biat.msscbreweryservice.config.JmsConfig;
import com.biat.msscbreweryservice.domain.Beer;
import com.biat.msscbreweryservice.events.BrewBeerEvent;
import com.biat.msscbreweryservice.mappers.BeerMapper;
import com.biat.msscbreweryservice.services.inventory.BeerInventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)//every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();
        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());
            log.debug("Min onhand is:" + beer.getMinOnhand());
            log.debug("Inventory is:" + invQOH);
            if (beer.getMinOnhand() >= invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });

    }
}
