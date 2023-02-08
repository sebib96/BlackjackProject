package com.skilldistiller.blackjack.entities;

public class BlackjackHand extends Hand{

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : this.cards) {
			handValue += card.getRank().getValue(); 
		}
		return handValue;
	}

	public boolean isBlackjack() {
		if(getHandValue() == 21) {
			return true;
		} else return false;
	}
	public boolean isBust() {
		if(getHandValue() > 21){
			return true;
		} else return false;
		
	}
	
	// Stretch Goals:
//	public boolean isHard() {
//		//add code to check sum of value in player hand
//
//		return true;
//	}
//	public boolean isSoft() {
//		//add code to check sum of value in player hand
//
//		return true;
//	}
}
