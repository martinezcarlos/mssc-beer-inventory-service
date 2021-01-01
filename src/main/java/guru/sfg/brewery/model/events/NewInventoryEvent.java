package guru.sfg.brewery.model.events;

import lombok.NoArgsConstructor;

/** Created by jt on 2019-07-21. */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
  private static final long serialVersionUID = -3420099596472211770L;

  public NewInventoryEvent(final BeerDto beerDto) {
    super(beerDto);
  }
}
