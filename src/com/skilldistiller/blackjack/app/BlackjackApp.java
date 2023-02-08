package com.skilldistiller.blackjack.app;

import java.util.Scanner;

import com.skilldistiller.blackjack.entities.Dealer;
import com.skilldistiller.blackjack.entities.Player;

public class BlackjackApp {
	private Scanner kb = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private boolean dealerBust = false;
	private boolean playerBust = false;

	public static void main(String[] args) {
		BlackjackApp run = new BlackjackApp();
		run.game();
	}

	public void game() {
		initialDealing();
		printDealerHand();
		printPlayerHand();
		promptPlayer();
		houseLogic();
		determineWinner();
	}

	public void printDealerHand() {
		System.out.println("\nDealer has " + dealer.getPlayerHand().getCards().size() + " cards.");
		System.out.println("Dealer Cards Shown: ");
		for (int i = 0; i < dealer.getPlayerHand().getCards().size(); i++) {
			if (i != 0) {
				System.out.println(dealer.getPlayerHand().getCards().get(i));
			}
		}
	}

	public void printEntireDealerHand() {
		System.out.println("\nDealer has " + dealer.getPlayerHand().getCards().size() + " cards.");
		System.out.println("Dealer Cards Shown: ");
		for (int i = 0; i < dealer.getPlayerHand().getCards().size(); i++) {
			System.out.println(dealer.getPlayerHand().getCards().get(i));
		}
		System.out.println("\n");
	}

	public void printPlayerHand() {
		System.out
				.println("Your Hand: " + player.getPlayerHand() + "\nValue: " + player.getPlayerHand().getHandValue());
	}

	public void initialDealing() {
		dealer.greeting();
		System.out.println("Card Dealt to Dealer\n");
		dealer.deal(dealer);
		System.out.println("Card Dealt to Player\n");
		dealer.deal(player);
		System.out.println("Card Dealt to Dealer\n");
		dealer.deal(dealer);
		System.out.println("Card Dealt to Player\n");
		dealer.deal(player);
		System.out.println("_________________________");
	}

	public void promptPlayer() {

		boolean running = true;
		do {
			System.out.println("[----Players Turn----]");
			System.out.println("1. Hit");
			System.out.println("2. Stay");
			int choice = kb.nextInt();
			switch (choice) {
			case 1:
				dealer.deal(player);
				System.out.println("Player Draws a Card");
				printPlayerHand();
				if (player.getPlayerHand().getHandValue() > 21) {
					playerBust = true;
					System.out.println("[BUST]\n");
					running = false;
				}
				if (player.getPlayerHand().getHandValue() == 21) {
					System.out.println("[Player hits 21]");
					System.out.println("\n[----Dealer Turn----]");
					running = false;
				}
				break;
			case 2:
				System.out.println("[Player Stays]");
				System.out.println("*Dealer Shows All Cards*");
				printEntireDealerHand();
				running = false;
				break;
			}
		} while (running);
	}

	public void houseLogic() {
		if (dealer.getPlayerHand().getHandValue() < 17) {
			System.out.println("Dealer Draws Card");
			dealer.deal(dealer);
		}
		if (dealer.getPlayerHand().getHandValue() > 17) {
			System.out.println("Dealer Stays");
			System.out.println("_______________________\n");
		}
	}

	public void determineWinner() {
		int playerScore = player.getPlayerHand().getHandValue();
		int dealerScore = dealer.getPlayerHand().getHandValue();
		if (dealerScore > 21) {
			dealerBust = true;
		}
		if (playerScore > 21) {
			playerBust = true;
		}

		if (playerScore > dealerScore && playerBust == false) {
			System.out.println("[PLAYER WINS]");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore);
			
		} else if (playerScore > dealerScore && playerBust == false && dealerBust == false) {
			System.out.println("[PLAYER WINS]");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore);
			
		} else if (dealerScore > playerScore && dealerBust == false) {
			System.out.println("[DEALER WINS]");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore);

		} else if (dealerScore > playerScore && dealerBust == false && playerBust == false) {
			System.out.println("[DEALER WINS]");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore);

		} else if (dealerScore == playerScore) {
			System.out.println("[PUSH]");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore);
			
		} else if (playerScore > dealerScore && playerBust == true && dealerBust == false) {
			System.out.println("[DEALER WINS]");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore);
			
		} else if (playerBust == true && dealerBust == true) {
			System.out.println("[PUSH]");
			System.out.println("_________________________");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore);
			System.out.println("_________________________");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore);
			
		} else if (dealerBust == true && playerBust == false && dealerScore > playerScore) {

		} else if(playerScore>dealerScore && playerBust == false && dealerBust == true) {
			System.out.println("[PLAYER WINS]");
			System.out.println("Player Hand:\n" + player.getPlayerHand());
			System.out.println("Player Score:\n" + playerScore+ "\n");
			System.out.println("_________________________");
			System.out.println("Dealer Hand:\n" + dealer.getPlayerHand());
			System.out.println("Dealer Score:\n" + dealerScore);
		}
	}
}
