package com.jitterted.ebp.blackjack;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

  @Test
  public void playerAndDealerHaveTwoCardAfterInitialDeal() throws Exception {
    Game game = new Game();
    game.initialDeal();
    assertThat(game.dealer().hand().size())
            .isEqualTo(2);
    assertThat(game.player().hand().size())
            .isEqualTo(2);
  }


}