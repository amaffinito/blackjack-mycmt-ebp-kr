package com.jitterted.ebp.blackjack;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        player.deposit(20);
        player.bet(10);
        player.win();
        assertThat(player.balance())
                .isEqualTo(30);
    }


    @Test
    public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        player.deposit(80);
        player.bet(70);
        player.tie();
        assertThat(player.balance())
                .isEqualTo(80);
    }

    @Test
    public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        player.deposit(35);
        player.bet(30);
        player.lose();
        assertThat(player.balance())
                .isEqualTo(5);
    }

    @Test
    public void playerWith40Bets15BalanceIs25() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        player.deposit(40);
        player.bet(15);
        assertThat(player.balance())
                .isEqualTo(25);
    }

    @Test
    public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        player.deposit(20);
        assertThat(player.balance())
                .isEqualTo(20);
    }

    @Test
    public void playerThatHitsDrawsCard() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        Deck deck = new Deck();
        // initial draw
        player.draw(deck, 2);
        player.hit(deck);
        assertThat(player.hand().size()).isEqualTo(3);
    }

    @Test
    public void playerThatKeepsHittingEventuallyBusts() throws Exception {
        Player player = new Player(PlayerType.PLAYER);
        Deck deck = new Deck();
        // initial draw
        player.draw(deck, 2);
        while(!player.hand().isBusted()) {
            player.hit(deck);
        }
        assertThat(player.busted());
    }
}
