public class GameBoard {
    // Attributes
    private int[][] board = new int[3][12];
    private int score;
    private int level;
    private int turn;

    public GameBoard(int level) { 
        this.level = level; 
        set_board();
    }

    private void set_board() {
        for (int i = 0; i < (level + 1) * 6; i++) {
            board[i / 12][i % 12] = i;
        }
    }

    public void update_board(int [] tiles_shut) {
        for (int tile : tiles_shut) {
            if (tile >= 1 && tile <= (level + 1) * 6) { // Arg Validation
                board[(tile -1) / 12][(tile -1) % 12] = 0;
            }
        }
    }

    public int[][] get_board() { return board; }
    public int get_score() { return score; }
    public int get_level() { return level; }
    public int get_turn() { return turn; }

    public String[] get_board_str() {
        String[] board_str = new String[5];
        board_str[0] = "+-------------------<S:" + Screen.ooo_format.format(score) + "|T:" + 
            Screen.oo_format.format(turn) + "|{-" + level + "-}>+";
        // 

        board_str[4] = "+-------------------------------------+";
        return board_str;
    }
}
