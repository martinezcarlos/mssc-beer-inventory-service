package guru.sfg.beer.inventory.service.services;

import common.jms.events.NewInventoryEvent;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jt on 2019-07-21.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

  private final BeerInventoryRepository beerInventoryRepository;

  @Transactional
  @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
  public void listen(final NewInventoryEvent event) {

    log.debug("Got Inventory: " + event.toString());

    beerInventoryRepository.save(BeerInventory.builder()
        .beerId(event.getBeerDto().getId())
        .upc(event.getBeerDto().getUpc())
        .quantityOnHand(event.getBeerDto().getQuantityOnHand())
        .build());
  }
}
