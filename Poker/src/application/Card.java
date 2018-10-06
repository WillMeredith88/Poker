package application;

import java.util.Random;

public class Card {
	/**
	 * Instance Variable(s)
	 */
	private int value;
	private char suit;
	
	/**
	 * Constructor(s)
	 */
	public Card(){//default constructor
		this(1, 'c');
	}
	//value(1- 13)
	public Card(int value, char suit){
		this.value = value;
		this.suit = suit;
	}
	
	/**
	 * Instance Method(s)
	 */

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getSuit() {
		return this.suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}
	
	public static int randomValue(){
		Random gen = new Random();
		return gen.nextInt(13) + 1;
	}
	
	public static char randomSuit(){
		Random gen = new Random();
		int ranInt = gen.nextInt(4);
		char ch;
		
		if(ranInt == 0){
			ch = 'c';//clubs
		}else if(ranInt == 1){
			ch = 'd';//diamonds
		}else if(ranInt == 2){
			ch = 'h';//hearts
		}else{
			ch = 's';//spades
		}
		return ch;
	}
	
	public String valueToString(){
		String val = "";
//		if(this.value == 1){
//			val += "Ace";
//		}else if(this.value == 11){
//			val += "Jack";
//		}else if(this.value == 12){
//			val += "Queen";
//		}else if(this.value == 13){
//			val += "King";
//		}else{
//			val += this.getValue();
//		}
		val += this.getValue();
		return val;
	}
	
	public String suitToString(){
		String ste = "";
		if(this.suit == 'c'){
		//	ste += "Club's ";
			ste += "c";
		}else if(this.suit == 'd'){
		//	ste += "Diamond's ";
			ste += "d";
		}else if(this.suit == 'h'){
		//	ste += "Heart's ";
			ste += "h";
		}else if(this.suit == 's'){
		//	ste += "Spade's ";
			ste += "s";
		}
		return ste;
	}
	
	public String toString(){
		return  this.valueToString() + suitToString();
	}
}
