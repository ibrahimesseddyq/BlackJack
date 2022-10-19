package app.Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Card> deck ;
    Player player ;
    Dealer dealer ;
    Scanner s ;

    public Game() {
        deck = new ArrayList<Card>();
        player = new Player();
         dealer = new Dealer();
         s = new Scanner(System.in);
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }


    public void StartGame() {
        int ch = 0;
        CreatePlayer();
        System.out.println("==========Let's Start==========");
        CreateCardlist();
        showPlayer();
        RegularMatch match= new RegularMatch(player,dealer,deck);
        match.startMatch();





    }


    public void CreateCardlist() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j, i);
                this.deck.add(card);
            }
        }

    }

    public void CreatePlayer() {

        System.out.println("Enter Your Name");
        String pl_name = s.next();
        player.setName(pl_name);
        System.out.println(" ===player -> " + player.getName() + " <- Created successfully=== ");
        System.out.println("Currents Coins : " + player.getCoins());
    }

    public void showPlayer() {
        System.out.println("Player Name : " + player.getName() + "  ||  Player coins : " + player.getCoins() + "  ||  Wins : " + player.getWin() + "  ||  Loses : " + player.getLose()
                + "  ||  Ties : " + player.getTie());
    }

    public void shwlistedcards() {
        deck.forEach((value) -> System.out.printf("(%d %d)", value.getHauteur(), value.getCouleur()));
    }





}






