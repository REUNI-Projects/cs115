public class LeaderBoard {
    private static String[][] top15 = new String[6][15];

    public static void load_leader_board() { // File read

    }

    public static void update_leader_board() { // File write

    }

    public static String get_rank(int rank) {
        if (rank < 1 || rank > 15) { // Arg Validation
            return "|   ??.     ---      ---      ---      ---      ---      ---     |\n" + 
                   "|          ---/--   ---/--   ---/--   ---/--   ---/--   ---/--   |\n"; 
        } 

        String rank_str = "|   " + Screen.oo_format.format(rank) + ".     ";

        for (int i = 0; i < 6; i++) {
            rank_str += top15[i][rank-1].substring(0,3);
            if (i != 5) { rank_str += "      "; } else { rank_str += "     |\n"; }
        }
        rank_str += "|          ";
        for (int i = 0; i < 6; i++) {
            rank_str += top15[i][rank-1].substring(4);
            if (i != 5) { rank_str += "   "; } else { rank_str += "   |\n"; }
        }

        return rank_str;
    }
}
