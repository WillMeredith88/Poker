package calculators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import datamodels.Board;
import datamodels.Card;
import datamodels.Deck;
import datamodels.Hand;
import datamodels.Player;

public class GameCalc {
	
	
	
	
	/**
	 * @author William Meredith
	 * Flush
	 * @param hand
	 * @param board
	 * @return int value corresponging to the high card of the flush.
	 * Zero if no flush is present
	 */
	public static int isFlush(Hand hand, Board board){
		int prev;
		//Spades 0, Hearts 1, Clubs 2, diamonds 3, 
		int suits[] = {0,0,0,0};
		int highCard[] = {0,0,0,0};
		Card current;
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.addAll(hand.getCards());
		cards.addAll(board.getBoardCards());
		
		if(cards.size() != 7){
			System.out.println("Error: incorrect number of cards: isFlush()");
			return 0;
		}
		
		for(int i=0; i < cards.size(); i++){
			current = cards.get(i);
			
			if(cards.get(i).getSuit() == 's'){
				
				if(current.getValue() > highCard[i]){
					highCard[0]=current.getValue();
				}
				
				suits[0]++;
			}
			else if(cards.get(i).getSuit() == 'h'){
				
				if(current.getValue() > highCard[i]){
					highCard[0]=current.getValue();
				}
				
				suits[1]++;
			}
			else if(cards.get(i).getSuit() == 'c'){
				
				if(current.getValue() > highCard[i]){
					highCard[0]=current.getValue();
				}
				
				suits[2]++;
			}
			else if(cards.get(i).getSuit() == 'd')
				
				if(current.getValue() > highCard[i]){
					highCard[0]=current.getValue();
				}
				
				suits[3]++;
		}
		
		//if flush return the high card
		for(int i =0 ; i < 4; i++){
			if(suits[i] >= 5){
					return highCard[i];
			}
		}
		
		
		return 0;
	}
	
	/**
	 * @author William Merdith
	 * Method determines if a player has a straight
	 * @param hand
	 * @param board
	 * @return
	 */
	public static int isStraight(Hand hand, Board board){
		
		int count=0;
		int highcard=0, lowcard=0;
		int val_last=0, val_current;
		
		ArrayList<Card> board_and_hand = new ArrayList<Card>();
		board_and_hand.addAll(hand.getCards());
		board_and_hand.addAll(board.getBoardCards());
		Collections.sort(board_and_hand);
		Iterator it = board_and_hand.iterator();
		
		while(it.hasNext()){
			
			if(count == 5){
				return highcard;
			}
			
			Card temp = (Card) it.next();
			highcard = temp.getValue();
			val_current=temp.getValue();
			
			if(lowcard == 0 || (val_current != (val_last++))){
				lowcard = temp.getValue();
				count=0;
			}
			
			count++;
			val_last=temp.getValue();
			
			
		}
		
		return -1;
		
	}
	
	/**
	 * @Author: William Meredith
	 * @param board
	 * @param hand
	 * @return int 1(True) -1(False)
	 * Method uses isStraight() as a subroutine
	 */
	public static int isStraightFlush(Board board, Hand hand){
		
		int straight_result = isStraight(hand, board);
		int highCardIndex, count=0;
		char high_card_suit;
		
		if(straight_result == -1)//result was not a straight
			return -1;
		
		ArrayList<Card> straight_list = new ArrayList<Card>();
		straight_list.addAll(board.getBoardCards());
		straight_list.addAll(hand.getCards());
		Collections.sort(straight_list);
		highCardIndex = straight_list.indexOf(straight_result);
		high_card_suit = straight_list.get(highCardIndex).getSuit();
		straight_list = (ArrayList<Card>) straight_list.subList(highCardIndex-5, highCardIndex);
		Iterator it = straight_list.iterator();
		
		while(it.hasNext()){
			if(count == 5)
					return 1;
			Card temp = (Card) it.next();
			
			if(temp.getSuit() == high_card_suit)//current card is correct suit
				count++;
			else
				return -1;//card was not correct suit, cannot be straight-flush
		}
		
		return -1;
	}
	
	
	/**
	 * @author William Meredith
	 * @param board
	 * @param hand
	 * @return (Int) an integer value where each digit indicated as pair of that
	 * value was found. 
	 */
	public static ArrayList<Card> isPair(Board board, Hand hand){
			
			//create and sort arraylist of all cards being examined
			ArrayList<Card> all_cards = new ArrayList<Card>();
			all_cards.addAll(board.getBoardCards());
			all_cards.addAll(hand.getCards());
			Collections.sort(all_cards);
			
			//create iterator and local variables to keep track of cards
			//being looked at
			Iterator<Card> card_iterator = all_cards.iterator();
			ArrayList<Card> pairValue = new ArrayList<Card>();
			ArrayList<Card> viewedCards = new ArrayList<Card>();
			Card current_card= all_cards.get(0);
			String final_result="";
			
			
			while(card_iterator.hasNext()){
				current_card = card_iterator.next();
					if(viewedCards.contains(current_card)){
						pairValue.add(current_card);
					}
			}
		
			
			if(pairValue.isEmpty()){
				return null;
			}
		
			
			return pairValue;
			
			
	}
	
	
	
	/*
	private final int HAND_SIZE = 2;
	private final int BOARD_SIZE = 5;
	private final int TOTAL_SIZE = 7;
	private int handCounter = 0;
	private int boardCounter = 0;
	private int totalCounter = 0;
	private Hand h;
	private Board b;
	private Card[] hand;
	private Card[] board;
	pr;
	private int[] arrSF; //straight flush array
	private boolean isStraight;
	private boolean isFlush;
	
	
	public GameCalc(){
		this(null, null);
	}
	
	public GameCalc(Hand hand){
		this(hand, null);
	}
	
	public GameCalc(Hand hand, Board board){
		System.out.println("GameCalc Running..." + "\n");
		this.setCards(hand, board);
		
	}
	
	
	public void setHand(Hand hand){
		if(hand == null){
			return;
		}else{
			this.h = hand;
			this.hand = hand.getHand();
			this.handCounter = hand.getCounter();
		}
	}
	
	public void setBoard(Board board){
		if(hand == null){
			return;
		}else{
			this.b = board;
			this.board = board.getBoard();
			this.boardCounter = board.getCounter();
		}
	}
	
	public void setCards(Hand hand, Board board){
		this.setHand(hand);
		this.setBoard(board);
		
		this.total = new Card[TOTAL_SIZE];
		this.totalCounter = this.handCounter + this.boardCounter;
		
		for(int i = 0; i < this.totalCounter; i++){
			if(i < this.handCounter){
				this.total[i] = this.hand[i];
			}else{
				this.total[i] = this.board[i - this.handCounter];
			}
		}
	}
	
	public void setNext(Card c){
		if(isFull()){
			System.out.println("There are already 7 cards in play! You cannot add another card!");
		}else{
			if(this.handCounter != 2){
				this.hand[this.handCounter] = c;
				this.total[this.handCounter] = this.hand[this.handCounter];
				this.handCounter++;
				this.totalCounter++;
				this.h.setNext(c);
			}else{
				this.board[this.boardCounter] = c;
				this.total[this.handCounter + this.boardCounter] = this.board[this.boardCounter];
				this.boardCounter++;
				this.totalCounter++;
				this.b.setNext(c);
			}
		}
	}
	
	public boolean isFull(){
		if(this.totalCounter == 7){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	public Card getHighCard(){
		System.out.println("Getting the high card...");
		if(this.hand[0].getValue() <= this.hand[1].getValue() || this.hand[1].getValue() == 1){
//			System.out.println(this.hand[0].getValue() + " " + this.hand[1].getValue());
			if(this.hand[1].getValue() == 1){
				System.out.println(this.hand[1].toString());
			}else if(this.hand[1].getValue() == 11){
				System.out.println(this.hand[1].toString());
			}else if(this.hand[1].getValue() == 12){
				System.out.println(this.hand[1].toString());
			}else if(this.hand[1].getValue() == 13){
				System.out.println(this.hand[1].toString());
			}else{
				System.out.println(this.hand[1].toString());
			}
			return this.hand[1];
		}else{
			System.out.println(this.hand[0].toString());
			return this.hand[0];
		}
	}
	
	public void checkPairs(){
		int counter = 0, pairCounter = 0;
		boolean noPair = true , pair = false, threeOfAKind = false, fourOfAKind = false;
		Card curr;
		int[] valuesArr = new int[this.totalCounter];
		System.out.println("Checking for pairs...");
		//fill values arr
		for(int i = 0; i < this.totalCounter; i++){
			valuesArr[i] = this.total[i].getValue();
		}

		for(int i = 0; i < this.totalCounter; i++){
			curr = this.total[i];
			valuesArr[i] = 0;//discounts the current card in this temp array
			for(int j = i + 1; j < this.totalCounter; j++){
				if(curr.getValue() == valuesArr[j]){
					valuesArr[j] = 0;
					counter++;
				}
			}//ends inner loop
			if(counter == 1){
				noPair = false;
				pair = true;
				pairCounter++;
			}else if( counter == 2){
				pair = false;
				threeOfAKind = true;
				pairCounter--;
			}else if(counter == 3){
				threeOfAKind = false;
				fourOfAKind = true;
			}
			counter = 0;
		}//ends outer loop
		if(noPair){
			System.out.println("You did not hit anything..." + "\n");
		}else if(fourOfAKind){
			System.out.println("You hit a Four Of A Kind!" + "\n");
		}else if(pair && threeOfAKind){
			System.out.println("You hit a Full House!" + "\n");
		}else if(threeOfAKind){
			System.out.println("You hit Three Of A Kind!" + "\n");
		}else if(pairCounter == 2){
			System.out.println("You hit Two Pair!" + "\n");
		}else{
			System.out.println("You hit a Pair!" + "\n");
		}
		//garbage collection
		curr = null;
		valuesArr = null;
	}
	
	public boolean checkStraight(){
		this.isStraight = false;
		int botEnd, curr, topEnd, counter;
		boolean hit = false;
		System.out.println("Checking for a straight...");
		if(contains(1)){
			botEnd = 13;
			counter = 1;
			for(int i = 0; i < this.totalCounter; i++){
				if(botEnd == this.total[i].getValue()){
					botEnd--;
					counter++;
					i = -1;
				}
			}
			if(counter >= 5){
				System.out.println("You have hit an A high straight!\n");
				hit = true;
				this.isStraight = true;
				return true;
			}
		}
		
		
		for(int i = 0; i < this.totalCounter; i++){
			curr = this.total[i].getValue();
			botEnd = curr - 1;
			topEnd = curr + 1;
			counter = 1;
			
			for(int j = 0; j < this.totalCounter; j++){
				if(this.total[j].getValue() == botEnd){
					j = 0;
					botEnd--;
					counter++;
				}else if(this.total[j].getValue() == topEnd){
					j = 0;
					topEnd++;
					counter++;
				}
			}
//			System.out.println("Total count for a straight: " + counter);
			if(counter >= 5){
				this.isStraight = true;
				System.out.println("You have hit a straight!\n");
				hit = true;
				return this.isStraight;
			}
		}
		if(!(hit)){
			System.out.println("You have not hit a straight...\n");
		}
		return this.isStraight;
	}
	
	public void checkFlush(){
		int clubCounter = 0, diamondCounter = 0, heartCounter = 0, spadeCounter = 0;
		this.isFlush = false;
		System.out.println("Checking for a flush...");
		for(int i = 0; i < this.totalCounter; i++){
			if(this.total[i].getSuit() == 'c'){
				clubCounter++;
			}else if(this.total[i].getSuit() == 'd'){
				diamondCounter++;
			}else if(this.total[i].getSuit() == 'h'){
				heartCounter++;
			}else{
				spadeCounter++;
			}
		}
//		System.out.println(clubCounter + " " + diamondCounter + " " + heartCounter + " " + spadeCounter);
		
		if(clubCounter >= 5){
			System.out.println("You hit a flush of clubs!\n");
			fillArrSF('c');
			this.isFlush = true;
		}else if(diamondCounter >= 5){
			System.out.println("You hit a flush of diamonds!\n");
			fillArrSF('d');
			this.isFlush = true;
		}else if(heartCounter >= 5){
			System.out.println("You hit a flush of hearts!\n");
			fillArrSF('h');
			this.isFlush = true;
		}else if(spadeCounter >= 5){
			System.out.println("You hit a flush of spades!\n");
			fillArrSF('s');
			this.isFlush = true;
		}else{
			System.out.println("You did not hit a flush!\n");
			this.isFlush = false;
		}
	}
	
	public void fillArrSF(char ch){
		this.arrSF = new int[7];
		int counter = 0;
		for(int i = 0; i < this.totalCounter; i++){
			if(this.total[i].getSuit() == ch){
				this.arrSF[counter] = this.total[i].getValue();
				counter++;
			} 
		}
	}
	
	public boolean checkStraightFlush(){
		int curr, topEnd, botEnd, counter = 0;
		System.out.println("Checking for straight flush...");
		if(this.isFlush && this.isStraight){
			if(contains(1)){
				botEnd = 13;
				counter = 1;
				for(int i = 0; i < this.totalCounter; i++){
					if(botEnd == this.total[i].getValue()){
						botEnd--;
						counter++;
						i = -1;
					}
				}
				if(counter >= 5){
					System.out.println("You have hit a Royal Flush!\n");
					return true;
				}
			}
			for(int j = 0; j < this.totalCounter ; j++){
				curr = this.arrSF[j];
				botEnd = curr - 1;
				topEnd = curr + 1;
				for(int i = 0; i < this.arrSF.length; i++){
					if(this.arrSF[i] == botEnd){
						counter++;
						i = 0;
						botEnd--;
					}
					if(this.arrSF[i] == topEnd){
						counter++;
						i = 0;
						topEnd++;
					}
				}
			}
			
			if(counter >= 5){
				if(contains(1, this.arrSF) && contains(13, this.arrSF)){
					System.out.println("You hit a royal flush!");
				}else{
					System.out.println("You hit a Straight flush!");
				}
				return true;
			}
		}else{
			System.out.println("You did not hit a straight flush.");
			return false;
		}
		return false;
	}
	
	public boolean contains(int value){
		for(int i = 0; i < this.totalCounter; i++){
			if(this.total[i].getValue() == value){
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int value, int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == value){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "GameCalc [ " + this.h.toString() + " - " + this.b.toString() + " ]";
	}	
	*/
	
	
	
	
	
}
