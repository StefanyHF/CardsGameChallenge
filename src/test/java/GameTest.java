import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

class GameTest {

    private final List<Card> fakeDeck1 = List.of(
            new Card(10),
            new Card(5),
            new Card(4),
            new Card(2),
            new Card(8)
    );

    private final List<Card> fakeDeck2 = List.of(
            new Card(5),
            new Card(8),
            new Card(7),
            new Card(2),
            new Card(1)
    );

    @Mock
    Shuffler shuffler;

    Player player1;

    Player player2;

    Game game;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void if_player1_card_is_greater_than_player2_then_he_should_get_his_card() {
        player1 = new Player(fakeDeck1, shuffler);
        player2 = new Player(fakeDeck2, shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();

        Assertions.assertEquals(6, player1.getTotalCardsSize());
        Assertions.assertEquals(4, player2.getTotalCardsSize());
    }

    @Test
    public void if_player2_card_is_greater_than_player1_then_he_should_get_his_card() {
        player1 = new Player(fakeDeck2, shuffler);
        player2 = new Player(fakeDeck1, shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();

        Assertions.assertEquals(6, player2.getTotalCardsSize());
        Assertions.assertEquals(4, player1.getTotalCardsSize());
    }

    @Test
    public void if_both_cards_have_the_same_value_then_they_should_be_added_to_the_tie_list() {
        player1 = new Player(List.of(
                new Card(5),
                new Card(1),
                new Card(4),
                new Card(2),
                new Card(1)
        ), shuffler);

        player2 = new Player(List.of(
                new Card(2),
                new Card(5),
                new Card(4),
                new Card(2),
                new Card(1)
        ), shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();

        Assertions.assertEquals(4, player2.getTotalCardsSize());
        Assertions.assertEquals(4, player1.getTotalCardsSize());
        Assertions.assertEquals(2, game.getTieCardsSize());
    }

    @Test
    public void if_there_was_a_tie_the_next_winner_get_all_the_cards_in_the_tie_list() {
        player1 = new Player(List.of(
                new Card(5),
                new Card(1),
                new Card(4),
                new Card(4),
                new Card(1)
        ), shuffler);

        player2 = new Player(List.of(
                new Card(2),
                new Card(5),
                new Card(4),
                new Card(2),
                new Card(1)
        ), shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();
        game.nextTurn();

        Assertions.assertEquals(7, player1.getTotalCardsSize());
        Assertions.assertEquals(3, player2.getTotalCardsSize());
        Assertions.assertEquals(0, game.getTieCardsSize());
    }

    @Test
    public void if_there_was_two_consecutive_tie_the_tie_list_shoud_have_four_cards() {
        player1 = new Player(List.of(
                new Card(5),
                new Card(1),
                new Card(9),
                new Card(4),
                new Card(1)
        ), shuffler);

        player2 = new Player(List.of(
                new Card(2),
                new Card(5),
                new Card(4),
                new Card(4),
                new Card(1)
        ), shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();
        game.nextTurn();

        Assertions.assertEquals(4, game.getTieCardsSize());
    }

    @Test
    public void if_there_was_a_tie_the_next_winner_get_all_the_4_cards_in_the_tie_list() {
        player1 = new Player(List.of(
                new Card(5),
                new Card(1),
                new Card(4),
                new Card(4),
                new Card(1)
        ), shuffler);

        player2 = new Player(List.of(
                new Card(2),
                new Card(5),
                new Card(4),
                new Card(2),
                new Card(1)
        ), shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();
        game.nextTurn();

        Assertions.assertEquals(7, player1.getTotalCardsSize());
        Assertions.assertEquals(3, player2.getTotalCardsSize());
        Assertions.assertEquals(0, game.getTieCardsSize());
    }

    @Test
    public void if_there_was_two_consecutive_tie_then_the_next_winner_should_win_all_the_cards() {
        player1 = new Player(List.of(
                new Card(5),
                new Card(1),
                new Card(9),
                new Card(4),
                new Card(1)
        ), shuffler);

        player2 = new Player(List.of(
                new Card(2),
                new Card(5),
                new Card(4),
                new Card(4),
                new Card(1)
        ), shuffler);

        Mockito.spy(player1);
        Mockito.spy(player2);

        game = new Game(player1, player2);

        game.nextTurn();
        game.nextTurn();
        game.nextTurn();

        Assertions.assertEquals(8, player1.getTotalCardsSize());
        Assertions.assertEquals(2, player2.getTotalCardsSize());
        Assertions.assertEquals(0, game.getTieCardsSize());
    }
}
