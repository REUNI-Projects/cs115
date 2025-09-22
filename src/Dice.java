import java.util.Random;

public class Dice {
    // Attributes
    private Random rng;

    public Dice() { rng = new Random(); }
    public Dice(int seed) { rng = new Random(seed); }

    public int roll() {
        return rng.nextInt(6) +1;
    }
}
