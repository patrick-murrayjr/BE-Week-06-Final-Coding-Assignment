package war.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Card> hand = new ArrayList<>(); // List of Card
	private int score; // set to 0 in the constructor
	private String name;

	public Player(String name) {
		setName(name);
		this.score = 0;
	}

	/**
	 * prints out information about the player and calls the describe method for
	 * each card in the Hand List)
	 */
	public void describe() {
		System.out.println(name + "'s hand:");
		for (Card card : hand) {
			card.describe();
		}
	}

	/**
	 * removes and returns the top card of the Hand
	 * 
	 * @return the top card of the Hand
	 */
	public Card flip() {
		return hand.remove(0);
	}

	/**
	 * takes a Deck as an argument and calls the draw method on the deck, adding the
	 * returned Card to the hand field
	 * 
	 * @param deck
	 */
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	/**
	 * adds 1 to the Player’s score field
	 */
	public void incrementScore() {
		this.score = score + 1;
	}

	// getters and setters
	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
