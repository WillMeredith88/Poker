package datamodels;

import java.util.Random;
/**
 * Represents a playing card.
 * @author William Meredith
 * @author Matthew Weigel
 * @version 1.0
 */
public class Card implements Comparable<Card>{
	/**
	 * The value of this card: king = 13, queen = 12, jack = 11, ten = 10, ..., 2 = 2, ace = 1.
	 */
	private int value;
	
	/**
	 * The suit of this card: club = c, spade = s, heart = h, diamond = d
	 */
	private char suit;
	
	/**
	 * Default constructor for a card, with random value and suit
	 */
	public Card(){
		this(randomValue(), randomSuit());
	}
	
	/**
	 * Constructs a card object with the specified value and suit.
	 * @param value The value of this card: king = 13, queen = 12, jack = 11, ten = 10, ..., 2 = 2, ace = 1.
	 * @param suit The suit of this card: club = c, spade = s, heart = h, diamond = d
	 */
	public Card(int value, char suit){
		this(suit, value);
	}
	
	/**
	 * Constructs a card object with the specified value and suit.
	 * @param suit The suit of this card: club = c, spade = s, heart = h, diamond = d
	 * @param value The value of this card: king = 13, queen = 12, jack = 11, ten = 10, ..., 2 = 2, ace = 1.
	 */
	public Card(char suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Returns an integer value specifying a random value, i.e. king = 13, queen = 12, 
	 * jack = 11, ten = 10, ... ace = 1.
	 * @return A random value
	 */
	public static int randomValue(){
		Random gen = new Random();
		return gen.nextInt(13) + 1;
	}
	
	/**
	 * Returns a character value specifying a random suit, i.e. club = c, diamond = d, etc.
	 * @return A random suit
	 */
	public static char randomSuit(){
		Random gen = new Random();
		int ranInt = gen.nextInt(4);
		char ch;
		if(ranInt == 0){
			ch = 'c';//club
		}else if(ranInt == 1){
			ch = 'd';//diamond
		}else if(ranInt == 2){
			ch = 'h';//heart
		}else{
			ch = 's';//spade
		}
		return ch;
	}
	
	/**
	 * Returns the value of this card.
	 * @return The value of this card
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Returns the true value of this card, I.e. Ace > King.
	 * @return The true value of this card
	 */
	public int getTrueValue() {
		int trueValue = value;
		if(value == 1) {
			trueValue = 14;
		}
		return trueValue;
	}
	
	/**
	 * Returns the suit of this card
	 * @return The suit of this card
	 */
	public char getSuit() {
		return suit;
	}
	
	/**
	 * Changes the suit of this card.
	 * @param suit The new suit of this card
	 */
	public void setSuit(char suit) {
		this.suit = suit;
	}
	/**
	 * Changes the value of this card.
	 * @param value The new value of this card
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Returns a string representation of this cards value, i.e. Ace, King, Queen, Jack, Ten, etc...
	 * @return A string representation of this cards value
	 */
	public String valueToString(){
		String str = "";
		if(value == 13) {
			str += "King";
		}else if(value == 12) {
			str += "Queen";
		}else if(value == 11) {
			str += "Jack";
		}else if(value == 10) {
			str += "Ten";
		}else if(value == 9) {
			str += "Nine";
		}else if(value == 8) {
			str += "Eight";
		}else if(value == 7) {
			str += "Seven";
		}else if(value == 6) {
			str += "Six";
		}else if(value == 5) {
			str += "Five";
		}else if(value == 4) {
			str += "Four";
		}else if(value == 3) {
			str += "Three";
		}else if(value == 2) {
			str += "Two";
		}else if(value == 1) {
			str += "Ace";
		}
		return str;
	}
	
	/**
	 * Returns a string representation of this cards suit, i.e. Club, Diamond, Heart, or Spade.
	 * @return A string representation of this cards suit
	 */
	public String suitToString(){
		String str = "";
		if(this.suit == 'c'){
			str += "Club";
		}else if(this.suit == 'd'){
			str += "Diamond";
		}else if(this.suit == 'h'){
			str += "Heart";
		}else if(this.suit == 's'){
			str += "Spade";
		}
		return str;
	}
	
	/**
	 * Returns a string representation of this card with it's value and suit.
	 * @return A string representation of this card
	 */
	public String toString(){
		return  this.valueToString() + " of " + suitToString() + "'s";
	}
	
	/**
	 * Returns an integer value specifying if this card is greater than, equal to, or less than
	 * some other card.
	 * @return An integer value specifying if this card is greater than, equal to, or less than
	 * some other card
	 */
	@Override
	public int compareTo(Card card) {
		int trueValue = getTrueValue();
		if(trueValue < card.getTrueValue()) {
			return -1;
		}else if(trueValue == card.getTrueValue()) {
			return 0;
		}else {
			return 1;
		}
	}
}
