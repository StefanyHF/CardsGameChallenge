import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ShuffleTest {
    ArrayList<Card> array = new ArrayList<>(Arrays.asList(new Card(1),new Card(2), new Card(3), new Card(4)));
    Shuffle shuffle = new Shuffle();

    @Test
    public void test() {
        ArrayList<Card> originalArray = new ArrayList<>();
        originalArray.addAll(array);
        shuffle.shuffleDeckCards(array);
        Assertions.assertFalse(Arrays.equals(array.toArray(), originalArray.toArray()));
    }

}