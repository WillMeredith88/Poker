package datamodels;

import java.util.ArrayList;
/**
 * Represents a hand full of playing cards.
 * @author William Meredith
 * @author Matthew Weigel
 * @version 1.0
 */
public class Hand {
	/**
	 * The size of this hand.
	 */
	private int handSize;
	
	/**
	 * The list of cards in this hand.
	 */
	private ArrayList<Card> cards;
	
	/**
	 * Default constructor for a hand, default hand size = 2. 
	 * Hand size must be greater than 0.
	 */
	public Hand(){
		this(2);
	}
	
	/**
	 * Constructor for a hand with the specified hand size. 
	 * Hand size must be greater than 0.
	 * @param size The size of this hand
	 */
	public Hand(int handSize){
		this(handSize, new ArrayList<Card>());
	}
	
	/**
	 *  Constructor for a hand with the specified hand size and card list.
	 *  Hand Size must be greater than 0.
	 * @param handSize The size of this hand
	 * @param cards A reference to an ArrayList of Cards
	 */
	public Hand(int handSize, ArrayList<Card> cards){
		this.handSize = handSize;
		this.cards = cards;
	}
	
	/**
	 * Randomizes the cards in this hand with no duplicate cards. This is for testing purposes.
	 */
	public void randomHand() {
		this.cards = new ArrayList<Card>();
		for(int i = 0; i < this.handSize; i++) {
			while(!(this.addCard(new Card())));
		}
	}
	
	/**
	 * Attempts to add a card to this hand, returns a boolean value specifying if 
	 * this card was successfully added.
	 * @param card A reference to the card to be added
	 * @return A boolean value specifying if this card was successfully added
	 */
	public boolean addCard(Card card) {
		if(this.cards == null) {
			cards = new ArrayList<Card>();
			cards.add(card);
			return true;
		}else if(this.cards.contains(card)) {
			return false;
		}else if(this.cards.size() >= this.handSize) {
			return false;
		}else {
			this.cards.add(card);
			return true;
		}
	}
	
	/**
	 * Removes the specified card from this hand, returns a boolean value specifying if
	 * this card was removed.
	 * @param card The specified card
	 * @return A boolean value specifying if this card was removed
	 */
	public boolean removeCard(Card card) {
		return this.cards.remove(card);
	}
	
	public void newHand() {
		this.cards = new ArrayList<Card>();
	}
	/**
	 * Returns a boolean value specifying if this hand is full.
	 * @return A boolean value specifying if this hand is full
	 */
	public boolean isFull(){
		if(this.cards.size() == handSize){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Returns a boolean value specyfing if this hand is empty.
	 * @return A boolean value specyfing if this hand is empty
	 */
	public boolean isEmpty() {
		return this.cards.size() == 0 || this.cards == null;
	}
	
	/**
	 * Returns the size of this hand.
	 * @return The size of this hand
	 */
	public int getHandSize() {
		return this.handSize;
	}
	
	/**
	 * Changes the size of this hand but does not change the contents of this hands card list.
	 * Hand size must be greater than 0.
	 * @param handSize The new size of this hand
	 */
	public void setHandSize(int handSize) {
		this.handSize = handSize;
	}
	
	/**
	 * Returns the card list of this hand.
	 * @return A reference to the card list of this hand
	 */
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	/**
	 * Changes the card list of this hand. 
	 * The size of the new card list must be equal to this hands size and
	 * must not have duplicate cards. 
	 * @param cards The new cards for this hand
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	/**
	 * Returns a boolean value specifying if this hand contains the specified card.
	 * @param card The specified card
	 * @return
	 */
	public boolean contains(Card card) {
		return this.cards.contains(card);
	}

	/**
	 * Returns a string representation of this hand including the hand size and card list.
	 * @return A string representation of this hand
	 */
	public String toString() {
		return "Hand Size: " + this.handSize + " Cards: " + cards;
	}
}
