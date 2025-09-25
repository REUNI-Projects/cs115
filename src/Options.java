import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Options {
    // Attributes
    private ArrayList<ArrayList<Integer>> options;

    public Options() {}

    public void generate_options(GameBoard board, Dice dice) {
        ArrayList<Integer> cur_board = IntStream.of(board.get_board()).filter(n -> n > 0).boxed()
            .collect(Collectors.toCollection(ArrayList::new));

        gen_opt_helper(cur_board, dice.get_sum(), 0, cur_board);
    }

    private void gen_opt_helper(ArrayList<Integer> cur_board, int goal, int idx,
        ArrayList<Integer> cur_option) {
        
        if (goal == 0) { options.add(cur_option); return; } // Valid opt
        if (goal < 0) { return; } // Invalid opt

        int i = idx;
        while (cur_board.get(i) < cur_board.get(cur_board.size() - 1) / 2 || 
            options.size() < 14) { // Search till halfway or has 13 options
            
            cur_option.add(cur_board.get(i));
            gen_opt_helper(cur_board, goal - cur_board.get(i), idx + 1, cur_option);
            cur_option.remove(cur_option.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> get_options() { return options; }
    public ArrayList<Integer> get_option(int i) { 
        if (i > 0 && i < options.size()) { 
            return options.get(i); 
        } else { return null; }
    }

    public String get_option_string(int i) { 
        // "[  ] 01 02 03 04 05 06 07 .."
        String slot = "                            ";
        if (i > 0 && i < options.size()) { 
            String option = "[" + Screen.oo_format.format(i) + "]";

            if (options.get(i).size() > 8) {
                for (int o = 0; o < 7; o++) {
                    option += " " + Screen.oo_format.format(options.get(i).get(o));
                }
                option += " ..";
            } else {
                for (int o = 0; o < options.get(i).size(); o++) {
                    option += " " + Screen.oo_format.format(options.get(i).get(o));
                    option += slot.substring(option.length());
                }
            }

            return option; 
        } else { return "                            "; }
    }
}
