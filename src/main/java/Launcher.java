import java.util.Random;

public class Launcher {
    public static void main(String[] args) {
        final int DECK_SIZE = 40;

        final Shuffler shuffler = new Shuffler(new Random());

        final Deck deck = new Deck(shuffler, DECK_SIZE);

        final Player player1 = new Player(deck.getCards().subList(0, DECK_SIZE / 2), shuffler);
        final Player player2 = new Player(deck.getCards().subList(DECK_SIZE / 2, DECK_SIZE), shuffler);

        Game game = new Game(player1, player2);
        game.start();
    }
}
