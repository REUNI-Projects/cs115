import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Options {
    // Attributes
    private ArrayList<ArrayList<Integer>> options = new ArrayList<>();

    // Constructor
    public Options() {}

    // Generator
    public void generate_options(GameBoard board, Dice dice) {
        ArrayList<Integer> cur_board = IntStream.of(board.get_board()).filter(n -> n > 0).boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        gen_opt_helper(cur_board, dice.get_sum(), 0, new ArrayList<Integer>());
    }

    private void gen_opt_helper(ArrayList<Integer> cur_board, int goal, int idx,
        ArrayList<Integer> cur_option) {
        
        if (goal == 0) { options.add(new ArrayList<>(cur_option)); return; } // Valid opt
        if (goal < 0) { return; } // Invalid opt

        while (idx < cur_board.size() && options.size() < 13) { 
            cur_option.add(cur_board.get(idx));
            gen_opt_helper(cur_board, goal - cur_board.get(idx), idx + 1, cur_option);
            cur_option.remove(cur_option.size() - 1); idx += 1;
        }
    }

    // Accessors
    public ArrayList<ArrayList<Integer>> get_options() { return options; }
    public ArrayList<Integer> get_option(int i) { 
        if (i >= 0 && i < options.size()) { 
            return options.get(i); 
        } else { return null; }
    }

    public String get_option_string(int i) { 
        // "[  ] 01 02 03 04 05 06 07 .."
        String slot = "                            ";
        if (i > 0 && i <= options.size() && i < 13) { 
            String option = "[" + Screen.oo_format.format(i) + "]";

            if (options.get(i-1).size() > 8) { // > 8 tiles
                for (int o = 0; o < 7; o++) {
                    option += " " + Screen.oo_format.format(options.get(i-1).get(o));
                }
                option += " ..";
            } else { // < 8 tiles
                for (int o = 0; o < options.get(i-1).size(); o++) {
                    option += " " + Screen.oo_format.format(options.get(i-1).get(o));
                }
                option += slot.substring(option.length());
            }

            return option; 
        } else { return "                            "; }
    }

    public void reset() { options.clear(); }
}
