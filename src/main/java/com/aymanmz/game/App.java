package com.aymanmz.game;

import com.aymanmz.game.elements.Deck;
import com.aymanmz.game.elements.Player;

import java.util.EmptyStackException;
import java.util.Scanner;

public class App {
    private final Scanner userInput = new Scanner(System.in);
    private final Player player = new Player();


    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    private void run() {
        displayGreetings();
        boolean running = true;
        while (running) {
            displayMenu();
            int selection = takeIntInput();
            if (selection == 1) {
                displayCardDrawn();
            } else if (selection == 2) {
                player.putCardsBackAndShuffle();
                System.out.printf("The cards have been shuffled%n%n");
            } else if (selection == 3) {
                running = false;
            } else {
                System.out.printf("Please select one of the option numbers!%n%n");
            }
        }
    }

    /**
     * Used to display the greeting when the program is displayed for the first time.
     */
    private void displayGreetings() {
        System.out.println("-----------------------------------");
        System.out.println("|   WELCOME TO THE DECK HANDLER!  |");
        System.out.println("-----------------------------------");
    }

    /**
     * Displays the menu options for the user.
     */
    private void displayMenu() {
        displayCards();
        System.out.println("1. Draw a card");
        System.out.println("2. Shuffle the cards");
        System.out.println("3. Exit");
    }

    /**
     * Displays the cards inside the deck in order.
     */
    private void displayCards() {
        Boolean isItFirstCard = true;
        System.out.print("The cards in your hands are: ");
        for (Integer card : player.getCardsOnHand()) {
            if (!isItFirstCard) {
                System.out.print(", " + card);
            } else {
                System.out.print(card);
                isItFirstCard = false;
            }
        }
        System.out.printf("%n%n");
    }

    /**
     * Takes an input from the user and turns into an Integer.
     *
     * @return will always be an Integer, regardless if it is positive or negative.
     */
    private Integer takeIntInput() {
        Integer result = null;
        while (result == null) {
            System.out.printf("%nWhat would you like to do? Select an option: ");
            String inputAsString = userInput.nextLine();
            try {
                result = Integer.parseInt(inputAsString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
        return result;
    }

    /**
     * Draws a card, and displays it to the user. Also shows the number of cards left in the deck
     */
    private void displayCardDrawn() {
        try {
            Integer cardDrawn = player.drawCard();
            System.out.println("The card you have drawn is: " + cardDrawn + ".");
            System.out.printf("You have %s cards left in the deck.%n%n", player.getDeck().getStackOfCards().size());
        } catch (EmptyStackException e) {
            System.out.printf("The deck is empty. You can not draw any more cards.%n%n");
        }
    }
}
