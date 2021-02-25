package com.jitterted.ebp.blackjack;

import java.util.Scanner;

public class Player {

    private PlayerType playerType;
    private int balance = 0;
    private int bet = 0;
    private Hand hand = new Hand();
    private boolean busted = false;
    private int totalAmountBet = 0;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void hit(Deck deck) {
        draw(deck, 1);
        busted = hand.isBusted();
    }

    public void stand() {
        return;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void bet(int betAmount) {
        totalAmountBet += betAmount;
        bet = betAmount;
        balance -= betAmount;
    }

    public void choose(Deck deck) {
        if(playerType == PlayerType.PLAYER) {
            // get Player's decision: hit until they stand, then they're done (or they go bust)
            System.out.println("[H]it or [S]tand?");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toLowerCase();
            if (choice.startsWith("s")) {
                stand();
            }
            if (choice.startsWith("h")) {
                hit(deck);
            }
            else {
                System.out.println("You need to [H]it or [S]tand");
            }
        }
        if(playerType == PlayerType.DEALER) {
            while (hand.value() <= 16) {
                draw(deck, 1);
            }
        }

    }

    public void draw(Deck deck, int numCardsToDraw) {
        for(int numCardsDrawn = 0; numCardsDrawn < numCardsToDraw ; numCardsDrawn++) {
            hand.add(deck.draw());
        }
    }

    public void dealHand(Hand hand) {
        this.hand = hand;
    }

    public Hand hand() {
        return hand;
    }

    public boolean busted() {
        return busted;
    }

    public int balance() {
        return balance;
    }

    public void win() {
        balance += bet * 2;
    }

    public void lose() {
        balance += bet * 0;
    }

    public void tie() {
        balance += bet * 1;
    }

    public int totalAmountBet() {
        return totalAmountBet;
    }
}
