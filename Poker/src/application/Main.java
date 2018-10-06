package application;
	
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
		//launch(args);
//		//value suit
//		Card c1 = new Card();
//		c1.setValue(6);
		Card c1 = new Card(1, 'c');
		Card c2 = new Card(13, 'c');
		Card c3 = new Card(12, 'c');
		Card c4 = new Card(11, 'c');
		Card c5 = new Card(10, 'c');
		Card c6 = new Card(6, 'd');
		Card c7 = new Card(7, 'd');
//		Hand h1 = new Hand(c6, c7);
////		h1.setNext(c2);
////		System.out.println(h1.toString());
//		System.out.println();
//		
//		Board b1 = new Board(c1, c2, c3);
//		b1.setNext(c4);
//		b1.setNext(c5);
////		System.out.println(b1.toString());
//		System.out.println();
		Hand h1 = new Hand();
		//h1.randomHand();
		h1.setHand(c1, c2);
		Board b1 = new Board();
		//b1.randomBoard();
		b1.setBoard(c3, c4, c5, c6, c7);
		System.out.println();
		
		GameCalc gc = new GameCalc(h1, b1);
//		gc.setNext(c5);
		System.out.println(gc.toString());
		
		gc.getHighCard();
		System.out.println();
		gc.checkPairs();
		gc.checkFlush();
		gc.checkStraight();
		gc.checkStraightFlush();
	}
}
