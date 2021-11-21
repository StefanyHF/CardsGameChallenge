import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


/**
 * Test: If a player with an empty draw pile tries to draw a card, the discard pile is
 * shuffled into the draw pile
 */
class PlayerTest {

    @Mock
    Shuffler shuffler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Mockito.doNothing().when(shuffler).shuffle(Mockito.anyList());
    }

    @Test
    public void draw_card_should_get_and_remove_last_card() {
        Player player = new Player(List.of(
                new Card(1),
                new Card(2),
                new Card(3),
                new Card(4),
                new Card(5)),
                shuffler
        );

        Card card = player.drawCard();

        Assertions.assertEquals(4, player.getCardsSize());
        Assertions.assertEquals(5, card.getNumber());
    }

    @Test
    public void should_add_cards_from_discard_pile_into_cards_if_its_empty() {
        Player player = new Player(new ArrayList<>(), shuffler);

        player.addToDiscard(new Card(1));
        player.addToDiscard(new Card(2));

        player.addDiscardsToPile();

        Assertions.assertEquals(2, player.getCardsSize());
        Assertions.assertEquals(0, player.getDiscardsSize());
    }

    @Test
    public void should_shuffle_the_cards_after_adding_from_discards() {
        Player player = new Player(new ArrayList<>(), shuffler);

        player.addToDiscard(new Card(1));
        player.addToDiscard(new Card(2));

        player.addDiscardsToPile();

        Mockito.verify(shuffler).shuffle(Mockito.anyList());
    }
}
