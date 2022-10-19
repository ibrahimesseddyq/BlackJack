package app.Classes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class    Dealer extends Person implements Hands{

    private ArrayList<Card> ShuffledCards ;
    private ArrayList<Card> Dealerhand ;


    public Dealer( ArrayList<Card> shuffledCards, ArrayList<Card> dealerhand) {
        super("Dealer", 0, 0, 0, 0);
        ShuffledCards = shuffledCards;
        Dealerhand = dealerhand;
    }


    public Dealer() {
        super("Dealer", 0, 0, 0, 0);
        this.Dealerhand = new ArrayList<Card>();
        this.ShuffledCards= new ArrayList<Card>();
    }

    public void dealerHand(){
        this.Dealerhand.forEach((val)-> System.out.printf("(%d %d) ",val.getHauteur(),val.getCouleur()));
    }

    public void Shuffled(ArrayList arr) {
        for(int i =0;i<100;i++){
            ArrayList card = tirerUneCarte(arr);
            ShuffledCards = (ArrayList) card.get(1);
            ShuffledCards.add((Card) card.get(0));
        }
    }

    public ArrayList tirerUneCarte(ArrayList arr) {
            Random random = new Random();
            int n = random.nextInt(52);
            return extraireCarte(arr, n);
    }


    public static ArrayList extraireCarte(ArrayList arr1, int n) {
        ArrayList cardlist = new ArrayList<>();
        Card carteTire;
        carteTire = (Card) arr1.get(n);
        arr1.remove(n);
        cardlist.add(carteTire);
        cardlist.add(arr1);
        return cardlist;
    }

    public ArrayList<Card> draw(ArrayList<Card> cards){
        this.Dealerhand.add(cards.get(0));
        cards.remove(0);
        return cards;
    }
    public void the2Draws(ArrayList<Card> cards){
        draw(cards);
        draw(cards);
    }
        public void calcHands(){
        this.score=0;
        int DealerScore = this.score;
        for(Card card : this.Dealerhand){
            if(card.getHauteur()==1 && DealerScore>=10){
                this.score += 1;
                DealerScore-=10;
            }else if(card.getHauteur()==1 && DealerScore<=10) {
                this.score += 11;
            }else if(card.getHauteur()==11 || card.getHauteur()==12 || card.getHauteur()==13 ){
                this.score+=10;
            }else{
                this.score+=card.getHauteur();
            }
        }
        }


    public ArrayList<Card> getShuffledCards() {
        return this.ShuffledCards;
    }

    public void setShuffledCards(ArrayList<Card> shuffledCards) {
        ShuffledCards = shuffledCards;
    }

    public ArrayList<Card> getDealerhand() {
        return Dealerhand;
    }

    public void setDealerhand(ArrayList<Card> dealerhand) {
        Dealerhand = dealerhand;
    }
}
