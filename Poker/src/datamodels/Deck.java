package datamodels;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of playing cards.
 * @author William Meredith
 * @author Matthew Weigel
 * @version 1.0
 */
public class Deck {
	private ArrayList<Card> cards;
	private final char[] validSuits = {'c', 's', 'h', 'd'};//clubs, spades, hearts, diamonds
	private final int[] validValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};//ace = 1, ..., king = 13
	private final int DECK_SIZE = validSuits.length * validValues.length;
	
	public Deck() {
		this.cards = new ArrayList<Card>();
		this.newDeck();
	}
	
	public void newDeck() {
		for(int i = 0; i < validSuits.length; i++) {
			for(int j = 0; j < validValues.length; j++) {
				this.cards.add(new Card(validSuits[i], validValues[j]));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public Card dealCard() {
		if(this.cards.isEmpty()) {
			return null;
		}
		this.shuffle();
		return this.cards.remove(0);
	}
	
	public ArrayList<Card> dealCards(int numOfCards){
		if(this.cards.size() < numOfCards) {
			return null;
		}
		this.shuffle();
		ArrayList<Card> flop = new ArrayList<Card>();
		flop.add(this.cards.remove(0));
		flop.add(this.cards.remove(0));
		flop.add(this.cards.remove(0));
		return flop;
	}
	
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	public boolean isFull() {
		return this.cards.size() == DECK_SIZE;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public char[] getValidSuits() {
		return validSuits;
	}

	public int[] getValidValues() {
		return validValues;
	}
	
	public int getNumOfCardsLeft() {
		return this.cards.size();
	}

	public int getDECK_SIZE() {
		return DECK_SIZE;
	}
	
	public String validSuitsToString() {
		String str = "[";
		for(int i = 0; i < validSuits.length; i++) {
			if(this.validSuits[i] == 'c'){
				str += "Club";
			}else if(this.validSuits[i] == 'd'){
				str += "Diamond";
			}else if(this.validSuits[i] == 'h'){
				str += "Heart";
			}else if(this.validSuits[i] == 's'){
				str += "Spade";
			}
			if(i < validSuits.length - 1) {
				str += " , ";
			}
		}
		return str + "]";
	}
	
	public String validValuesToString() {
		String str = "[";
		for(int i = 0; i < validValues.length; i++) {
			if(this.validValues[i] == 13) {
				str += "King";
			}else if(this.validValues[i] == 12) {
				str += "Queen";
			}else if(this.validValues[i] == 11) {
				str += "Jack";
			}else if(this.validValues[i] == 10) {
				str += "Ten";
			}else if(this.validValues[i] == 9) {
				str += "Nine";
			}else if(this.validValues[i] == 8) {
				str += "Eight";
			}else if(this.validValues[i] == 7) {
				str += "Seven";
			}else if(this.validValues[i] == 6) {
				str += "Six";
			}else if(this.validValues[i] == 5) {
				str += "Five";
			}else if(this.validValues[i] == 4) {
				str += "Four";
			}else if(this.validValues[i] == 3) {
				str += "Three";
			}else if(this.validValues[i] == 2) {
				str += "Two";
			}else if(this.validValues[i] == 1) {
				str += "Ace";
			}
			if(i < validValues.length - 1) {
				str += " , ";
			}
		}
		return str + "]";
	}
	
	public String cardsToString() {
		Collections.sort(this.cards);
		String str = "";
		if(this.cards.isEmpty()) {
			return str;
		}
		for(Card card: cards) {
				str+= "\t" + card + "\n";
		}
		return str;
	}
	
	public String toString() {
		return "Cards Left: " + this.cards.size() + " out of " + this.DECK_SIZE + "\n" + "Valid Values: " + this.validValuesToString() + "\nValid Suits: " + this.validSuitsToString() 
				+ "\nCards in Deck: \n" + cardsToString();
	}
}
