import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LeaderBoard {
    private static final String DB = "db.csv";
    private static ArrayList<ArrayList<String>> top15 = new ArrayList<ArrayList<String>>(6);

    public static String load_leader_board() { // File read
        boolean load_err = false;
        if (top15.isEmpty()) {
            for (int i = 0; i < 6; i++) { top15.add(new ArrayList<String>(15)); }
            try (BufferedReader reader = new BufferedReader(new FileReader(DB))) {
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] row_data = row.split(",");
                    for (int ii = 0; ii < 6; ii++) { top15.get(ii).add(row_data[ii]); }
                }
            } catch (FileNotFoundException err) { // Try make file if file not found
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB))) {}
                catch (IOException err2) { load_err = true; }
            } catch (IOException err) { load_err = true; }
        }
        if (load_err) { return S.Error.Err051.get_msg(); }
        return "";
    }

    // File write
    public static void update_leader_board(String name, int score, int turn, S.Level lv) { 

    }

    public static String get_rank(int rank) {
        if (rank < 1 || rank > 15) { // Arg Validation
            return "|   ??.     ---      ---      ---      ---      ---      ---     |\n" + 
                   "|          ---/--   ---/--   ---/--   ---/--   ---/--   ---/--   |\n"; 
        } 

        String rank_str = "|   " + Screen.oo_format.format(rank) + ".  ";
        String name_str = "";
        String score_str = "|          ";

        // "nam 123/23,"
        for (int i = 0; i < 6; i++) {
            if (top15.get(i).size() <= i|| top15.get(i).get(rank-1) == null || top15.get(i).get(rank-1).length() != 10) {
                name_str += "   ---   "; score_str += "---/--   ";
            } else {
                name_str += "   " + top15.get(i).get(rank-1).substring(0,3) + "   ";
                score_str += rank_str += top15.get(i).get(rank-1).substring(4) + "   ";
            }
        }
        rank_str += name_str + "  |\n" + score_str + "|\n";

        return rank_str;
    }
}
