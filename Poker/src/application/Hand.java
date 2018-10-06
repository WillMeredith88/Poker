package application;


public class Hand {
	/**
	 * Instance Variable(s)/
	 */
	private final int MAX_SIZE = 2;
	private Card[] hand;
	private int[] values;
	private char[] suits;
	private int counter = 0;
	
	/**
	 * Constructor(s)
	 */
	
	public Hand(){
		this(null, null);
	}
	
	public Hand(Card c1, Card c2){
		this.setHand(c1, c2);
	}
	
	/**
	 * Instance Method(s)
	 */
	
	public void setNext(Card c){
		if(isFull()){
			System.out.println("Your hand is full! You cannot add another card");
		}else if(c == null){
			return;
		}else{
			this.hand[this.counter] = c;
			this.values[this.counter] = c.getValue();
			this.suits[this.counter] = c.getSuit();
			this.counter++;
			System.out.println("Added " + c.toString() + "To Hand");
		}
	}
	
	public void setHand(Card c1, Card c2){
		this.hand = new Card[MAX_SIZE];
		this.values = new int[MAX_SIZE];
		this.suits = new char[MAX_SIZE];
		this.setNext(c1);
		this.setNext(c2);
	}
	
	public void randomHand(){
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
		this.setNext(new Card(Card.randomValue(), Card.randomSuit()));
	}
	
	public boolean isFull(){
		if(this.counter == 2){
			return true;
		}else{
			return false;
		}
	}

	public Card[] getHand() {
		return this.hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
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

	public int getCounter() {
		return this.counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getMAX_SIZE() {
		return this.MAX_SIZE;
	}
	

	@Override
	public String toString() {
		String msg = "";
		for(int i = 0; i < this.counter; i++){
			
		}
		return "[" + hand[0].toString() + ", " + hand[1].toString() + "]";
	}
}
