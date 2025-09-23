import java.util.ArrayList;

public class Options {
    // Attributes
    private ArrayList<ArrayList<Integer>> options;

    public Options() {
        
    }

    private void generate_options() {}

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
