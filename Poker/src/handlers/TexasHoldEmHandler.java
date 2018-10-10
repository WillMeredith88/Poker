package handlers;

import java.util.ArrayList;
import java.util.Random;

import datamodels.Player;

public class TexasHoldEmHandler {
	private ArrayList<Player> players;
	private int dealer;//keep track of index of dealer
	private double pot;
	private double smallBlind;
	private double bigBlind;
	
	public TexasHoldEmHandler() {//default smallBlind $1, $2 big blind
		this(1, 2);
	}
	
	public TexasHoldEmHandler(int smallBlind, int bigBlind) {
		this(new ArrayList<Player>(), smallBlind, bigBlind);
	}
	
	public TexasHoldEmHandler(ArrayList<Player> players, int smallBlind, int bigBlind) {
		this(players, smallBlind, bigBlind, 0, 0.0);//default dealer is 0, default pot is 0.0
	}
	
	public TexasHoldEmHandler(ArrayList<Player> players, int smallBlind, int bigBlind, int dealer, double pot) {
		this.players = players;
		this.smallBlind= smallBlind;
		this.bigBlind = bigBlind;
		this.dealer = dealer;
		this.pot = pot;
	}
	
	public boolean setNewDealer() {
		if(this.players == null || this.players.size() == 0) {
			return false;
		}else {
			Random rand = new Random();
			this.dealer =  rand.nextInt(this.players.size());
		}
		return true;
	}
	
	public boolean start() {
		return false;
	}
}
