import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Random;

class ShufflerTest {

    private List<Card> cards = List.of(new Card(1),new Card(2), new Card(3), new Card(4));

    @Mock
    Random random;

    Shuffler shuffler = new Shuffler(random);

    @Test
    public void test() {

    }
}
