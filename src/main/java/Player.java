import java.util.ArrayList;

public class Player {
    private ArrayList<Card> drawPile = new ArrayList<>();
    private final ArrayList<Card> discardPile = new ArrayList<>();
    private final Shuffle shuffle = new Shuffle();
    private Card cardPlayed;

    public int getTotalCardsSize() {
        return drawPile.size() + discardPile.size();
    }

    public void setDrawPile(ArrayList<Card> drawPile) {
        this.drawPile = drawPile;
    }

    public void addToDiscard(Card card){
        discardPile.add(card);
    }

    public void drawCard(){
        if(drawPile.isEmpty() && !discardPile.isEmpty()){
            shuffle.shuffleDeckCards(discardPile);
            drawPile.addAll(discardPile);
            discardPile.clear();
        }
        cardPlayed = drawPile.get(0);
        drawPile.remove(0);
    }

    public Card getCardPlayed(){
        return cardPlayed;
    }
}
