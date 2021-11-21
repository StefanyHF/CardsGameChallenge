import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
    private Random random = new Random();

    public void shuffleDeckCards(ArrayList<Card> cards) {
        for (int count = cards.size() - 1; count > 0; count--) {
            Card temp = cards.get(count);
            int randomIndex = random.nextInt(count);

            Card randomValue = cards.get(randomIndex);

            cards.set(count, randomValue);
            cards.set(randomIndex, temp);
        }
    }
}
