package view;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	Random rand = new Random();
	public ArrayList<Card> Cards = genDeck();

//(String cName, int rType, int rCost, int aType, int aAmnt)
public ArrayList<Card> genDeck() {
	ArrayList<Card> allCards = new ArrayList<Card>();
	//String rTypes[] = {"bricks","weapons","crystals"};
	//String aTypes[] = {"wall","fence","builder","warrior","mage","attack"};
	for(int i=1; i<=3; i++) { //adds cards that dont boost rType
		allCards.add(new Card("Wall","bricks",1,"fence",3));
		allCards.add(new Card("Base","bricks",1,"castle",2));
	}
	for(int i=1; i<=2; i++) {
		allCards.add(new Card("School","bricks",8,"builders",1));
	}
	return allCards;
} //ends genDeck

public void shuffle(){
	ArrayList<Card> randDeck = new ArrayList<Card>();
	randDeck.addAll(Cards);
	Cards.clear();
	while(randDeck.size()>0) {
		int r=rand.nextInt(randDeck.size());
		Cards.add(randDeck.get(r));
		randDeck.remove(r);
	}
} //ends shuffle

public ArrayList<Card> pullRandom(int n) {
	ArrayList<Card> pulled = new ArrayList<Card>();
	for(int i = 0; i < n; i++) {
		int r = rand.nextInt(Cards.size());
		pulled.add(Cards.get(r));
		Cards.remove(r);
	}
	return pulled;
}

}