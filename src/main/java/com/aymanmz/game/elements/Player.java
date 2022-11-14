package com.aymanmz.game.elements;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Player {
    //Variables
    private Deck deck;
    private List<Integer> cardsOnHand = new ArrayList<>();

    //Constructor
    public Player() {
        deck = new Deck();
        for (int i = 0; i < 2; i++) {
            drawCard();
        }
    }

    //Getters and Setters
    public Deck getDeck() {
        return deck;
    }
    public List<Integer> getCardsOnHand() {
        return cardsOnHand;
    }
    //Methods
    /**
     * Take the top card from the deck and add it to your hand.
     * @return the card drawn as well.
     */
    public Integer drawCard() throws EmptyStackException {
        Integer cardFromTop = deck.removeCardFromTop();
        cardsOnHand.add(cardFromTop);
        return cardFromTop;
    }
    /**
     * Put all the cards back to the deck, and shuffle.
     */
    public void putCardsBackAndShuffle() {
        for (Integer card : cardsOnHand) {
            deck.addCardOnTop(card);
        }
        cardsOnHand = new ArrayList<>();
        deck.shuffleCards();
    }
}
