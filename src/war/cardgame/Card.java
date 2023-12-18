package war.cardgame;

public class Card {

	private int value; // contains a value from 2-14 representing cards 2-Ace
	private String name; // (e.g. Ace of Diamonds, or Two of Hearts)

	public Card(String name, int value) {
		setName(name);
		setValue(value);
	}

	/**
	 * prints out information about a card)
	 */
	public void describe() {
		System.out.println(getName());
	}

	// getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
