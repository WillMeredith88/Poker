package application;

public class Board {
	/**
	 * Instance Variable(s)
	 */
	private final int MAX_SIZE = 5;
	private Card[] board;
	private int[] values;
	private char[] suits;
	private int counter = 0;
	
	/**
	 * Constructor(s)
	 */
	public Board(){
		this(null, null, null, null, null);
	}
	
	public Board(Card c1, Card c2, Card c3){
		this(c1, c2, c3, null, null);
	}
	
	public Board(Card c1, Card c2, Card c3, Card c4, Card c5){
		this.setBoard(c1, c2, c3, c4, c5);
	}
	
	/**
	 * Instance Method(s)
	 */
	public void setNext(Card c){
		if(isFull()){
			System.out.println("The board is full! You cannot add another card!");
		}else if(c == null){
			return;
		}else{
			this.board[counter] = c;
			this.values[counter] = c.getValue();
			this.suits[counter] = c.getSuit();
			this.counter++;
			System.out.println("Added " + c.toString() + "To Board");
		}
	}
	
	public void setFlop(Card c1, Card c2, Card c3){
		this.setNext(c1);
		this.setNext(c2);
		this.setNext(c3);
	}
	
	public void setBoard(Card c1, Card c2, Card c3, Card c4, Card c5){
		this.board = new Card[MAX_SIZE];
		this.values = new int[MAX_SIZE];
		this.suits = new char[MAX_SIZE];
		
		this.setFlop(c1, c2, c3);
		this.setNext(c4);
		this.setNext(c5);
	}
	
	public void randomBoard(){
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
	}
	
	public boolean isFull(){
		if(this.counter == 5){
			return true;
		}else{
			return false;
		}
	}
	
	public Card[] getBoard() {
		return this.board;
	}

	public void setBoard(Card[] board) {
		this.board = board;
	}

	public int[] getValues() {
		return this.values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public char[] getSuits() {
		return this.suits;
	}

	public void setSuits(char[] suits) {
		this.suits = suits;
	}

	public int getMAX_SIZE() {
		return this.MAX_SIZE;
	}

	public int getCounter() {
		return this.counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "[" + this.board[0].toString() + ", " + this.board[1].toString() + ", " + this.board[2].toString() + ", " + 
				this.board[3].toString() + ", " + this.board[4].toString() + "]";
	}
}
