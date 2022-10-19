package app.Classes;

import java.util.ArrayList;

public interface Hands {
    public void the2Draws(ArrayList<Card> cards);
    public void calcHands();
    public ArrayList<Card> draw(ArrayList<Card> cards);
}
