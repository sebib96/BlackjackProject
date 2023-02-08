package com.skilldistiller.blackjack.entities;

public class Player {
	private Hand playerHand;
	private int sumOfHand;
	
	public Player() {
	playerHand = new BlackjackHand();
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public int getSumOfHand() {
		return sumOfHand;
	}

	public void setSumOfHand(int sumOfHand) {
		this.sumOfHand = sumOfHand;
	}
	
	public void receiveCard(Card card) {
		playerHand.addCard(card);
	}
	//print hand method
	public void printHand() {
		System.out.println(getPlayerHand().toString());
	}
}	
	
