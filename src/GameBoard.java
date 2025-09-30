public class GameBoard {
    // Attributes
    private int[] board = new int[36];
    private int score;
    private int level;
    private int turn;

    // Constructor
    public GameBoard(int level) { 
        this.level = level; 
        set_board();
    }

    // Methods
    private void set_board() {
        for (int i = 0; i < (level + 1) * 6; i++) {
            board[i] = i + 1;
        }
        update_score();
        turn = 0;
    }

    private void update_score() {
        int sum = 0;
        for (int tile : board) {
            sum += tile;
        }
        score = sum;
    }

    public void update_board(int [] tiles_shut) {
        for (int tile : tiles_shut) {
            if (tile >= 1 && tile <= (level + 1) * 6) { // Arg Validation
                board[tile - 1] = 0;
            }
        }
        update_score();
        turn += 1;
    }

    // Accessors
    public int[] get_board() { return board; }
    public int get_score() { return score; }
    public int get_level() { return level; }
    public int get_turn() { return turn; }

    public String[] get_board_str() {
        String[] board_str = new String[5];
        board_str[0] = "+-------------------<S:" + Screen.ooo_format.format(score) + "|T:" + 
            Screen.oo_format.format(turn) + "|{-" + level + "-}>+";
        for (int i = 0; i < 36; i++) {
            if (i % 12 == 0) {
                board_str[i/12 + 1] = "| ";
            }

            if (i < (level + 1) * 6) {
                if (board[i] == 0) {
                    board_str[i/12 + 1] += "██ ";
                } else {
                    board_str[i/12 + 1] += Screen.oo_format.format(board[i]) + " ";;
                }
            } else {
                board_str[i/12 + 1] += "   ";
            }

            if (i % 12 == 11) {
                board_str[i/12 + 1] += "|";
            }
        }
        board_str[4] = "+-------------------------------------+";
        return board_str;
    }
}
