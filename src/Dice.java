import java.util.Random;

public class Dice {
    // Attributes
    private Random rng;
    private int[] dice_values = new int[6];
    private int dice_sum = 0;
    private int dice_count = 1;
    private int level = 0;

    public Dice(int dice_count, S.Level level) { 
        set_dice_count(dice_count); 
        set_level(level.get_num());
        rng = new Random(); 
    }
    public Dice(int dice_count, int seed) { set_dice_count(dice_count); rng = new Random(seed); }

    public void set_dice_count(int count) { dice_count = count; }
    private void set_level(int lv) { level = lv; }

    public int get_sum() { return dice_sum; }
    public int get_count() { return dice_count; }
    public int[] get_values() {return dice_values; }

    public void roll() { 
        for (int i = 0; i < dice_values.length; i++) {
            if (i > dice_count - 1) { dice_values[i] = 0; }
            dice_values[i] = rng.nextInt(6) +1;
        }
    }

    public String[] get_dice_str() {
        String[] dice_str = new String[5];
        dice_str[0] = "+ Dice:    " + Screen.oo_format.format(dice_sum) + " +";

        for (int i = 0; i < dice_values.length; i++) {
            if (i % 3 == 0) { dice_str[i/3 + 1] += "| "; }

            if (i < dice_count) {
                dice_str[i/3 + 1] += "[" + dice_values[i] + "] ";
            } else if (i < level + 1) {
                dice_str[i/3 + 1] += "[X]";
            } else {
                dice_str[i/3 + 1] += "[_]";
            }

            if ((i + 1) % 3 == 0) { dice_str[i%2] += "|"; }
        }

        dice_str[3] = "|             |";
        dice_str[4] = "+ [r-] Roll # +";
        return dice_str;
    }


}
