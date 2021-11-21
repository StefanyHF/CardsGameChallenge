public class Card {

    private final int number;

    Card(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                '}';
    }
}
