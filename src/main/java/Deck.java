import java.util.ArrayList;

public class Deck {

    private final ArrayList<Card> cards = new ArrayList<>();

    Deck(Shuffler shuffler, int size) {
        while (cards.size() < size) {
            for (int i = 1; i <= 10; i++) {
                cards.add(new Card(i));
            }
        }
        shuffler.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
