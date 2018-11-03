package view;

import java.io.InputStream;
import java.nio.Buffer;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
//import application.Card;

public class GameController {
	
	//ArrayList<Card> playerHand
	
	//Card archer = new Card("Archer","attack","weapons", .5, -1);
	//Card wall = new Card("Wall","attack","weapons", .5, -1);
	
	@FXML
	Button button_test;
	
	@FXML
	ProgressBar p1Castle;
	
	@FXML
	ProgressBar p2Castle;
	
	@FXML
	Button button_discard;
	
	
	
	@FXML ImageView card1;
	@FXML ImageView card2;
	@FXML ImageView card3;
	@FXML ImageView card4;
	@FXML ImageView card5;
	@FXML ImageView card6;
	@FXML ImageView card7;
	@FXML ImageView card8;
	
	@FXML
	HBox playerHand;
	
	ImageView draggedCard = null;
	
	@FXML
	void initialize() {
		//Tooltip tip = new Tooltip("hey");
		//button_discard.setTooltip(tip);
		ImageView cardList[]= {card1, card2, card3, card4, card5, card6, card7, card8};
		
		
		for(int i = 0; i < cardList.length; i++) {
			ImageView thisCard = cardList[i];
			thisCard.setOnMouseClicked(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		              		               
		            }

		        });
		}
		
		
		for(int i = 0; i < cardList.length; i++) {
			ImageView thisCard = cardList[i];
			thisCard.setOnMouseDragged(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		                draggedCard = thisCard;
		                
		                thisCard.setOpacity(.5);
		                System.out.println(thisCard.getImage());
		            }
		        });
			}
		
		for(int i = 0; i < cardList.length; i++) {
			ImageView thisCard = cardList[i];
			thisCard.setOnMouseReleased(new EventHandler<MouseEvent>()
		        {
		            @Override
		            public void handle(MouseEvent t) {
		            	if(draggedCard == null) {
		            		return;
		            	}
		            	double xPos = t.getSceneX();
		            	double yPos = t.getSceneY();
		                if((xPos > 780 && xPos < 860) && yPos > 410 && yPos < 550) {
		                	String currentDir = System.getProperty("user.dir");
		                	String fullDir = "file:\\" + currentDir + "\\images\\Wall.png";
		                	System.out.println(fullDir);
		                	Image img = new Image(fullDir);
		                	//System.out.println(img.getWidth());
		                	thisCard.setImage(img);
		                }
		                thisCard.setOpacity(1);
		                draggedCard = null;
		            }
		        });
			}
		
		//card2.setDisable(true);
	}
	
	public void ButtonAction(ActionEvent event) {
		Button b = (Button) event.getSource();
		
		if(b == button_test) {
			addToCastle(2,10);
		}
	}
	
	public void ImageAction(ActionEvent event) {
		ImageView img = (ImageView) event.getSource();
		
		System.out.println(img.getId());
	}
	
	/*
	void PlayCard() {
		switch(card.cType) {
		
		case "attack":
			addToCastle(1, card.hpChange);
			addToCastle(2, card.oppHpChange);
		}
	}
	*/
	
	void addToCastle(int player, double amount) {
		ProgressBar targetBar = player == 1? p1Castle : p2Castle;
		double current = targetBar.getProgress();
		double add = amount/100;
		targetBar.setProgress(current + add);
	}
	
	private void Sleep(int milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (Exception e) {
			System.out.println("Sleep failed?");
		}
	}
	
}
