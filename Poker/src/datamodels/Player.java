package datamodels;

/**
 * Represents a player in a card game.
 * @author William Meredith
 * @author Matthew Weigel
 * @version 1.0
 */
public class Player {
	private String name;
	private Hand hand;
	private double stack;//optional
	
	public Player() {//default name = john doe
		this("John Doe");
	}
	
	public Player(String name) {
		this(name, null);	
	}
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}
	
	public Player(String name, Hand hand, double stack) {
		this(name, hand);
		this.stack = stack;
	}
	
	public boolean recieveCard(Card card) {
		boolean success = false;
		if(this.hand == null) {
			this.hand = new Hand();
			success = this.hand.addCard(card);
		}else if(this.hand.isFull()) {
			success = false;//hand is full, cannot add card
		}else {//hand isn't full and isn't null
			success = this.hand.addCard(card);
		}
		return success;
	}
	
	public void newHand() {
		this.hand.newHand();
	}
	
	public boolean bet(double betSize) {
		if(betSize <= this.stack && betSize >= 0) {
			this.stack -= betSize;
		}
		return (betSize <= this.stack && betSize >= 0);
	}
	
	public boolean allIn() {
		return this.bet(this.stack);
	}
	
	public double recieveChips(double amt) {
		this.stack += amt;
		return this.stack;
	}
	
}
