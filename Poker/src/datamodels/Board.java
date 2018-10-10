package datamodels;

import java.util.ArrayList;

/**
 * Represents a game board.
 * @author William Meredith
 * @author Matthew Weigel
 * @version 1.0
 */
public class Board {
	private int boardSize;
	private ArrayList<Card> cards;
	
	public Board() {//default board size is 5
		this(5);
	}
	
	public Board(int boardSize) {
		this(boardSize, new ArrayList<Card>());
	}
	
	public Board(int boardSize, ArrayList<Card> cards) {
		this.boardSize = boardSize;
		this.cards = cards;
	}
	
	public boolean addCard(Card card) {
		if(this.cards.size() < this.boardSize) {
			this.cards.add(card);
			return true;
		}
		return false;
	}
	
	public void newBoard() {
		this.cards = new ArrayList<Card>();
	}
	
	public boolean isFull() {
		return this.cards.size() == this.boardSize;
	}
	
	public boolean isEmpty() {
		return this.cards == null || this.cards.size() == 0;
	}
	
	public boolean contains(Card card) {
		return this.cards.contains(card);
	}
	
	public String toString() {
		return "Board Size: " + this.boardSize + " Board: " + this.cards;
	}
}
