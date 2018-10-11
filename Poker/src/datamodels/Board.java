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
	private ArrayList<Card> deck;
	private ArrayList<Card> boardCards;
	
	
	public Board() {//default board size is 5
		this(5);
	}
	
	public Board(int boardSize) {
		this(boardSize, new ArrayList<Card>());
	}
	
	public Board(int boardSize, ArrayList<Card> cards) {
		this.boardSize = boardSize;
		this.boardCards = cards;
	}
	
	public ArrayList<Card> getBoardCards(){
		return this.boardCards;
	}
	
	
}
