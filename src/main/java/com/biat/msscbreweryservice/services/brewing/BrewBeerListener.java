package com.biat.msscbreweryservice.services.brewing;

import com.biat.msscbreweryservice.Repository.BeerRepository;
import com.biat.msscbreweryservice.config.JmsConfig;
import com.biat.msscbreweryservice.domain.Beer;
import com.biat.msscbreweryservice.events.BrewBeerEvent;
import com.biat.msscbreweryservice.events.NewInventoryEvent;
import com.biat.msscbreweryservice.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {
    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();
        Beer beer = beerRepository.getOne(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityOnHand());
        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed Beer" + beer.getMinOnhand() + "QOH:" + beerDto.getQuantityOnHand());
        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);


    }
}
