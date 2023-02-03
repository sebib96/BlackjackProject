package com.skilldistiller.blackjack.testing;

import java.util.Scanner;

import com.skilldistiller.blackjack.entities.Card;
import com.skilldistiller.blackjack.entities.Deck;

public class Dealing {
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// deal 5 card from the deck displaying each of the dealt cards  
		Dealing dealer = new Dealing();
		dealer.deal();
	}
	public void deal() {
		Deck theDeck = new Deck();
		System.out.println(theDeck.getDeck().size());
		System.out.println("How many cards do you want?");
		int userNumCards = kb.nextInt();
		kb.nextLine();
		System.out.println("Shuffling Cards...");
		theDeck.shuffle();
		
		
		for(int numCardsDealtSoFar = 0; numCardsDealtSoFar<userNumCards;numCardsDealtSoFar++) {
			Card cardDealt = theDeck.giveCard();
			System.out.println(cardDealt);
			System.out.println("Cards left: " + theDeck.checkDeckSize()+ "Just dealt: "+ cardDealt);
		}
	}
}
