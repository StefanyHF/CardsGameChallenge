import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ShufflerTest {

    private final ArrayList<Card> cards = new ArrayList<>(List.of(
            new Card(1),
            new Card(2),
            new Card(3),
            new Card(4),
            new Card(5)
    ));

    @Mock
    Random random;

    Shuffler shuffler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        shuffler = new Shuffler(random);
    }

    @Test
    public void shuffler_should_shuffle_the_list() {
        Mockito.when(random.nextInt(Mockito.anyInt())).thenReturn(0, 2, 1, 0);

        shuffler.shuffle(cards);

        Assertions.assertEquals(4, cards.get(0).getNumber());
        Assertions.assertEquals(5, cards.get(1).getNumber());
        Assertions.assertEquals(2, cards.get(2).getNumber());
        Assertions.assertEquals(3, cards.get(3).getNumber());
        Assertions.assertEquals(1, cards.get(4).getNumber());
    }
}
