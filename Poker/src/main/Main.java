package main;
	
import calculators.GameCalc;
import datamodels.Board;
import datamodels.Card;
import datamodels.Deck;
import datamodels.Hand;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main{ //extends Application {
	/*@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		Card card = new Card();
		System.out.println(card);
		Hand hand = new Hand();
		hand.randomHand();
		System.out.println(hand);
		hand.addCard(new Card());
		System.out.println(hand);
		
		Deck deck = new Deck();
		System.out.println(deck);
	}
}
