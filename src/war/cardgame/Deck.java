package war.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	private final int OFFSET_VALUE = 2;

	public List<Card> cards = new ArrayList<>(); // (List of Card)
	private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] names = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen",
			"King", "Ace" };

	public Deck() {
		/*
		 * In the constructor, when a new Deck is instantiated, the Cards field should
		 * be populated with the standard 52 cards.
		 */
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < names.length; j++) {
				cards.add(new Card(names[j] + " of " + suits[i], j + OFFSET_VALUE));
			}
		}
	}

	/**
	 * randomizes the order of the cards
	 */
	public void shuffle() {

		Random rand = new Random();
		Card temp;
		for (int i = 0; i < cards.size(); i++) {
			int rndIndex = rand.nextInt(cards.size());
			temp = cards.get(i);
			cards.set(i, cards.get(rndIndex));
			cards.set(rndIndex, temp);
		}
	}

	/**
	 * removes and returns the top card of the cards ArrayList
	 * 
	 * @return the top Card from the deck
	 */
	public Card draw() {
		if (deckIsNotEmpty()) {
			return cards.remove(0);
		}
		return null;
	}

	/**
	 * checks to see if the deck is not empty
	 * 
	 * @return true if cards remain in the deck, false if no cards remain
	 */

	public boolean deckIsNotEmpty() {
		return (cards.size() > 0);
	}

	/**
	 * prints out information about the deck
	 */
	public void describe() {
		for (Card card : cards) {
			card.describe();
		}
	}
}
