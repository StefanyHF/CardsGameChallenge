import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private final Stack<Card> cards = new Stack<>();
    private final ArrayList<Card> discardPile = new ArrayList<>();

    private final Shuffler shuffler;

    public Player(List<Card> cards, Shuffler shuffler) {
        this.shuffler = shuffler;
        this.cards.addAll(cards);
    }

    public int getCardsSize() {
        return cards.size();
    }

    public int getDiscardsSize() {
        return discardPile.size();
    }

    public int getTotalCardsSize() {
        return cards.size() + discardPile.size();
    }

    public boolean hasCards() {
        return !cards.isEmpty() || !discardPile.isEmpty();
    }

    public void addToDiscard(Card card) {
        discardPile.add(card);
    }

    public void addAllToDiscard(List<Card> cards) {
        discardPile.addAll(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty() && !discardPile.isEmpty()) {
            addDiscardsToPile();
        }
        return cards.pop();
    }

    public void addDiscardsToPile() {
        shuffler.shuffle(discardPile);
        cards.addAll(discardPile);
        discardPile.clear();
    }
}
