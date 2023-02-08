package com.skilldistiller.blackjack.entities;

public class Dealer extends Player {
	private Hand dealerHand;
	Deck theDeck = new Deck();

	public Dealer() {
		dealerHand = new BlackjackHand();
	}

	public void deal(Player player) {
		Card card = theDeck.giveCard();
		player.receiveCard(card);
		System.out.println("Cards Left: "+theDeck.checkSize());
	}

	public void greeting() {
		System.out.println("Welcome to Blackjack");
	}
}
