package app.Classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class RegularMatch implements Match {
    private ArrayList<Card> deck ;

    Player player ;
    Dealer dealer ;

    Scanner s;


    public RegularMatch(Player player, Dealer dealer,ArrayList<Card> deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck=deck;
        s = new Scanner(System.in);
    }

    @Override
    public void startMatch() {
        int choice;
        do {
            System.out.println("Player Coins : " + player.getCoins());
            System.out.println("Chose your bet Price =>");
            System.out.println("+++++++++++++++");
            System.out.println("1=> 100 ");
            System.out.println("2=> 500 ");
            System.out.println("3=> 1000 ");
            System.out.println("4=> 3000 ");
            System.out.println("+++++++++++++++");
            System.out.print("=> ");
            choice = s.nextInt();

            switch (choice) {
                case 1: {
                    player.setBet(100);
                    challenging();
                    break;
                }
                case 2: {
                    player.setBet(500);
                    challenging();
                    break;
                }
                case 3: {
                    player.setBet(1000);
                    challenging();
                    break;
                }
                case 4: {
                    player.setBet(3000);
                    challenging();
                    break;
                }
            }

        } while (choice != 0);

    }

    @Override
    public void challenging() {
        dealer.Shuffled(deck);
        player.draw(dealer.getShuffledCards());
        player.draw(dealer.getShuffledCards());

        player.calcHands();
        int score = player.getScore();
        if(score !=21) {
            System.out.println("You have " + score + " in your hand");
            dealer.draw(dealer.getShuffledCards());
            dealer.draw(dealer.getShuffledCards());
            Card fcard = dealer.getDealerhand().get(0);
            System.out.println("Dealer has (" + fcard.getCouleur() + "," + fcard.getHauteur() + ") and 1 hidden card ");
            Integer choice;

            do{
                System.out.println("Choose :");
                System.out.println("1 - HIT ");
                System.out.println("2 - STAND");
                choice= s.nextInt();
                if(choice ==1 ){
                    player.draw(dealer.getShuffledCards());
                    player.calcHands();
                    System.out.println("You have now  " );
                    player.playerHand();
                    System.out.println("And score : " + player.getScore() + " in your hand");
                }
                if(player.getScore()==21){
                    System.out.println("You Win");
                    break;
                }
                if(player.getScore()>21){
                    System.out.println("You Loose");
                    break;
                }
                if(choice ==2){
                    dealer.calcHands();
                    System.out.println("The Dealer has " + dealer.getScore());
                    if(player.getScore()<dealer.getScore() && dealer.getScore()<=21){
                        System.out.println("You loose");
                        break;
                    }
                    do{
                        dealer.draw(dealer.getShuffledCards());
                        dealer.calcHands();
                        System.out.println("Dealer has "+dealer.getScore() );
                        if(player.getScore()<dealer.getScore() && dealer.getScore()<=21){
                            System.out.println("You loose");
                            break;
                        }
                        else if(dealer.getScore()>21){
                            System.out.println("You win Dealer is "+(dealer.getScore()-21)+" above 21 ");
                            break;
                        }
                    }while(dealer.getScore()<=21);
                }
            }while(choice == 1 );



        }else {
            System.out.println("You Win!!");
        }
    }
}
