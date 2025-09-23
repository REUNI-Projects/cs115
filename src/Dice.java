import java.util.Random;

public class Dice {
    // Attributes
    private Random rng;
    private int face = 1;

    public Dice() { rng = new Random(); }
    public Dice(int seed) { rng = new Random(seed); }

    public int get_face() { return face; }
    public void roll() { face = rng.nextInt(6) +1; }
}
