import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class DeckTest {

    @Mock
    Shuffler shuffler;

    Deck deck;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Mockito.doNothing().when(shuffler).shuffle(Mockito.anyList());

        deck = new Deck(shuffler, 40);
    }

    @Test
    public void deck_size_should_be_40() {
        Assertions.assertEquals(40, deck.getSize());
    }

    @Test
    public void deck_should_be_shuffled() {
        Mockito.verify(shuffler).shuffle(Mockito.any());
    }
}