import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private final Deck deck = new Deck();

    @Test
    public void test() {
        Assertions.assertEquals(40, deck.createDeck().size());
    }
}