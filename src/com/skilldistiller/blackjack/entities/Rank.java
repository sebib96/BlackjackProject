package com.skilldistiller.blackjack.entities;

public enum Rank {
TWO(2, "Two"),
THREE(3, "Three"),
FOUR(4, "Four"),
FIVE(5, "Five"),
SIX(6, "Six"),
SEVEN(7, "Seven"),
EIGHT(8, "Eight"),
NINE(9, "Nine"),
TEN(10, "Ten"),
//------------------------------------//
KING(10, "King"),
QUEEN(10, "Queen"),
JACK(10, "Jack"),
//-----------------------------------//
ACE(11, "Ace");

private int value;
@SuppressWarnings("unused")
private String name;

	Rank(int value, String name) {
	this.value = value;
	this.name = name;
}

	public int getValue() {
	return value;
}
	public String toString() {
		return ""+value;
	}

}
