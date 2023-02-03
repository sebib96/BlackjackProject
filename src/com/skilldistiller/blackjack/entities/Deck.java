package com.skilldistiller.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(52);
	
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				System.out.println(card);
				deck.add(card);
			
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	
	public Card giveCard() {
		shuffle();
		return deck.remove(0);
		//maybe add shuffle method before or after giving card.
	}
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
}
