import java.util.ArrayList;

public class Game {
    private final Deck deck = new Deck();
    private final Player player1 = new Player();
    private final Player player2 = new Player();
    private boolean hasWinner = false;
    private boolean isTie = false;
    private String turnWinner;
    private final ArrayList<Card> tieCards = new ArrayList<>();

    public void startGame() {
        deck.createDeck();
        deck.setPlayersPile(player1, player2);

        while (!hasWinner) {
            int s1 = player1.getTotalCardsSize();
            int s2 = player2.getTotalCardsSize();
            player1.drawCard();
            player2.drawCard();

            if (player1.getCardPlayed().getNumber() > player2.getCardPlayed().getNumber()) {
                turnWinner = "Player 1";
                player1.addToDiscard(player1.getCardPlayed());
                player1.addToDiscard(player2.getCardPlayed());
                if (!tieCards.isEmpty()) {
                    for (int i = 0; i < tieCards.size(); i++) {
                        player1.addToDiscard(tieCards.get(i));
                    }
                    tieCards.clear();
                    isTie = false;
                }
            } else if (player2.getCardPlayed().getNumber() > player1.getCardPlayed().getNumber()) {
                turnWinner = "Player 2";
                player2.addToDiscard(player2.getCardPlayed());
                player2.addToDiscard(player1.getCardPlayed());
                if (!tieCards.isEmpty()) {
                    for (int i = 0; i < tieCards.size(); i++) {
                        player2.addToDiscard(tieCards.get(i));
                    }
                    tieCards.clear();
                    isTie = false;
                }
            } else {
                isTie = true;
                tieCards.add(player1.getCardPlayed());
                tieCards.add(player2.getCardPlayed());
            }

            checkWinner();
            showTurnResults(s1, s2);
        }
    }

    public void showTurnResults(int s1, int s2) {
        System.out.println(
                "Player 1 (" + s1 + ") : " + player1.getCardPlayed() +
                        "\n Player 2 (" + s2 + ") : " + player2.getCardPlayed()
        );
        if (!hasWinner) {
            System.out.println(turnWinner + " won this turn \n");
        } else if (isTie) {
            System.out.println("This round is a tie");
        } else {
            System.out.println(turnWinner + " won the game \n");
        }
    }

    public void checkWinner() {
        if (player1.getTotalCardsSize() == 0) {
            hasWinner = true;
            turnWinner = "Player 2";
        } else if (player2.getTotalCardsSize() == 0) {
            hasWinner = true;
            turnWinner = "Player 1";
        }
    }
}



