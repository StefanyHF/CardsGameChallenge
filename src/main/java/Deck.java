import java.util.ArrayList;

public class Deck {

    private static final int DECK_CARDS_NUM = 40;
    private Shuffle shuffle = new Shuffle();
    private ArrayList<Card> deck = new ArrayList<>();

    public ArrayList<Card> createDeck() {
        while (deck.size() < DECK_CARDS_NUM) {
            for (int i = 1; i <= 10; i++) {
                deck.add(new Card(i));
            }
        }
        shuffle.shuffleDeckCards(deck);
        return deck;
    }

    public void setPlayersPile(Player first, Player second) {
        ArrayList<Card> firstPlayer = new ArrayList<>();
        for (int i = 0; i < DECK_CARDS_NUM / 2; i++) {
            firstPlayer.add(deck.get(i));
        }
        first.setDrawPile(firstPlayer);
        ArrayList<Card> secondPlayer = new ArrayList<>();
        for (int i = DECK_CARDS_NUM / 2; i < DECK_CARDS_NUM; i++) {
            secondPlayer.add(deck.get(i));
        }
        second.setDrawPile(secondPlayer);
    }
}
