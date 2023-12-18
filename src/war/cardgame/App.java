package war.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {

		// Instantiate a Deck and two Players, call the shuffle method on the deck.
		Deck deck = new Deck();
		deck.shuffle();

		// Create a list of random player names
		List<String> playerNames = new ArrayList<>(
				Arrays.asList("Alice", "Bob", "Carla", "Doug", "Emily", "Frank", "Gina", "Harry", "Isabel", "John"));

		// Shuffle the list to randomize it
		Collections.shuffle(playerNames);

		// assign the first name from the shuffled list to player1, and the second to
		// player 2
		Player player1 = new Player(playerNames.get(0));
		Player player2 = new Player(playerNames.get(1));

		System.out.println("*****************************************");
		System.out.println("            The Game of WAR!");
		System.out.println("            " + player1.getName() + " vs. " + player2.getName());
		System.out.println("*****************************************");
		// Using a traditional for loop, iterate 52 times calling the Draw method on the
		// other player each iteration using the Deck you instantiated.
		for (int i = 0; i < 52; i++) {
			if (i % 2 == 0) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}

		// Using a traditional for loop, iterate 26 times and call the flip method for
		// each player.
		for (int i = 0; i < 26; i++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();

			// Using the Card describe() method when each card is flipped
			// illustrates the game play.
			System.out.print(player1.getName() + " plays: ");
			player1Card.describe();
			System.out.print(player2.getName() + " plays: ");
			player2Card.describe();

			// Compare the value of each card returned by the two player’s flip methods.
			// Call the incrementScore method on the player whose card has the higher value.
			// Printing the winner of each turn adds interest.
			if (player1Card.getValue() > player2Card.getValue()) {
				player1.incrementScore();
				System.out.println(player1.getName() + " scores a point!");
			} else if (player2Card.getValue() > player1Card.getValue()) {
				player2.incrementScore();
				System.out.println(player2.getName() + " scores a point!");
			} else {
				System.out.println("No points awarded.");
			}

			// Printing the updated score after each turn shows game progression.
			System.out.println("Score after round " + (i + 1) + ": " + player1.getName() + ": " + player1.getScore()
					+ " | " + player2.getName() + ": " + player2.getScore());

			System.out.println("-----------------------------------------");
		}

		// After the loop, compare the final score from each player.
		// Print the final score of each player and either "Player 1", "Player 2", or
		// "Draw" depending on which score is higher or if they are both the same.

		// At the end of the game: print the final score of each player and the winner’s
		// name or “Draw” if the result is a tie.
		System.out.println("            Game Results");
		System.out.println("-----------------------------------------");

		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " Wins with a score of " + player1.getScore());
			System.out.println(player2.getName() + " Loses with a score of " + player2.getScore());
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println(player2.getName() + " Wins with a score of " + player2.getScore());
			System.out.println(player1.getName() + " Loses with a score of " + player1.getScore());
		} else {
			System.out.println("The game is a Draw, each player scored " + player1.getScore() + " points.");
		}

	}// end main

}// end App
