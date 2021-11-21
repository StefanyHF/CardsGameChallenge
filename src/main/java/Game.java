import java.util.ArrayList;

public class Game {
    private final Player player1;
    private final Player player2;

    private final ArrayList<Card> tieCards = new ArrayList<>();

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        while (player1.hasCards() && player2.hasCards()) {
            nextTurn();
        }

        checkWinner();
    }

    private void checkWinner() {
        if (player1.hasCards()) {
            System.out.println("Player 1 wins the game!");
        }

        if (player2.hasCards()) {
            System.out.println("Player 2 wins the game!");
        }
    }

    public void nextTurn() {
        System.out.print("Player 1 (" + player1.getTotalCardsSize() + " cards): ");
        Card card1 = player1.drawCard();
        System.out.println(card1.getNumber());

        System.out.print("Player 2 (" + player2.getTotalCardsSize() + " cards): ");
        Card card2 = player2.drawCard();
        System.out.println(card2.getNumber());

        if (card1.getNumber() > card2.getNumber()) {
            showRoundWinnerMessage(1);

            player1.addToDiscard(card2);
            player1.addToDiscard(card1);

            if (!tieCards.isEmpty()) {
                player1.addAllToDiscard(tieCards);
                tieCards.clear();
            }
        } else if (card2.getNumber() > card1.getNumber()) {
            showRoundWinnerMessage(2);

            player2.addToDiscard(card1);
            player2.addToDiscard(card2);

            if (!tieCards.isEmpty()) {
                player2.addAllToDiscard(tieCards);
                tieCards.clear();
            }
        } else {
            System.out.println("No winner in this round\n");
            tieCards.add(card1);
            tieCards.add(card2);
        }
    }

    private void showRoundWinnerMessage(int playerNumber) {
        System.out.println("Player " + playerNumber + " wins this round\n");
    }

    public int getTieCardsSize() {
        return tieCards.size();
    }
}



