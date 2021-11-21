import java.util.List;
import java.util.Random;

public class Shuffler {

    private final Random random;

    public Shuffler(Random random) {
        this.random = random;
    }

    public void shuffle(List<Card> cards) {
        for (int count = cards.size() - 1; count > 0; count--) {
            Card temp = cards.get(count);
            int randomIndex = random.nextInt(count);

            Card randomValue = cards.get(randomIndex);

            cards.set(count, randomValue);
            cards.set(randomIndex, temp);
        }
    }
}
