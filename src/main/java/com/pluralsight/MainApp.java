package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    static final Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Player> getPlayers = new ArrayList<>();
        System.out.print("=== Welcome to Blackjack ===\n");
        System.out.println();

        System.out.print("Enter number of players: ");
        int numberPlayers = myScanner.nextInt();
        myScanner.nextLine();

        for (int i = 0; i < numberPlayers; i++) {
            System.out.print("Enter player name " + (i + 1) + ": ");
            String name = myScanner.nextLine();
            getPlayers.add(new Player(name));
        }

        for (Player player : getPlayers) {
            for (int i = 0; i < 2; i++) {
                player.getHand().deal(deck.deal());
            }
        }

        for (Player player : getPlayers) {
            System.out.println("\n=== " + player.getName() + "'s turn ===");

            boolean isFaceUp = false;
            while (!isFaceUp) {
                System.out.println(player.getName() + "'s hand" + player.getHand() + " (Score is: " + player.getScore() + ") ");

                if (player.getScore() > 21) {
                    System.out.println(player.getName() + " busted! ");
                    return;
                }
                System.out.print("Would you like to stay/hit(h or s): ");
                String choice = myScanner.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "h":
                        Card newCard = deck.deal();
                        player.getHand().deal(newCard);
                        System.out.println("You drew " + newCard);
                        break;
                    case "s":
                        System.out.println(player.getName() + " stays with " + player.getScore() + " points");
                        isFaceUp = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Pick hit or stay!");
                        break;
                }
            }
        }
        Player winner = null;
        int highScore = 0;

        System.out.println("\n=== Final Score ===\n");
        for (Player player: getPlayers) {
            int score = player.getScore();
            System.out.println(player.getName() + ": " + score);
            if (score <= 21 && score > highScore) {
                highScore = score;
                winner = player;
            }

        }
        myScanner.close();
    }
}
//    // deal 2 cards
//        for(int i = 0; i < 2; i++) {
//// get a card from the deck
//        Card card = deck.deal();
//// deal that card to the hand
//        hand.deal(card);
//    }
//    int handValue = hand.getValue();
//        System.out.println("This hand is worth " + handValue);
//}