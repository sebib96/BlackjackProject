package com.skilldistiller.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<>();
	
	
	public void addCard(Card cardDealt) {
		cards.add(cardDealt);
		
	}
	
	public Hand() {
		cards = new ArrayList<>();
	}

	public void clear() {
	cards.clear();
	}
	
	public abstract int getHandValue();


	@Override
	public String toString() {
		return "" + cards;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
