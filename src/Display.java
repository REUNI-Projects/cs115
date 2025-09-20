import java.text.DecimalFormat;

public class Display {
    static DecimalFormat score_format = new DecimalFormat("000");

    public static final String main_menu() {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|    █▀▀▀█ █   █ █   █ ▀▀█▀▀          █▀▀▀▄ █▀▀▀█ █   █   ▄      |\n" + 
            "|    ▀■■■▄ █■■■█ █   █   █     THE    █■■■█ █   █  █■█  ■■█■■    |\n" + 
            "|    █▄▄▄█ █   █ █▄▄▄█   █            █▄▄▄▀ █▄▄▄█ █   █   ▀      |\n" + 
            "|  ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  |\n" + 
            "|                                                                |\n" +  
            "|    [p] Play                                                    |\n" + 
            "|    [l] Leader Board                                            |\n" + 
            "|    [q] Quit                                                    |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                  by 7cevage    |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n";
        return screen;
    }
    public static final String level_menu() {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|                   >> Difficulty Selection <<                   |\n" + 
            "|                                                                |\n" + 
            "|    [0] [-0-] Easy                                              |\n" + 
            "|    [1] [-1-] Normal (OG)                                       |\n" + 
            "|    [2] [-2-] Hard                                              |\n" +  
            "|    [3] [-3-] Challenge                                         |\n" + 
            "|    [4] [-4-] Nightmare                                         |\n" + 
            "|    [5] [-5-] Impossible                                        |\n" + 
            "|                                                                |\n" + 
            "|    [b] Back                                                    |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n";
        return screen;
    }
    public static final String in_game(int score, int level, int[] board, String[] options) {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n";
        screen += "" + 
            "|    +--------------------<Score:072|{-2-}>+     Dice:    08     |\n" + 
            "|    | 01 02 03 04 05 ██ 07 08 09 10 11 12 |     [6] [2] [X]     |\n" + 
            "|    | ██ ██ ██ ██ ██ ██                   |     [_] [_] [_]     |\n" + 
            "|    |                                     |                     |\n" + 
            "|    +-------------------------------------+    [d] # of dice    |\n" +  
            "|                                                                |\n" + 
            "|    [1] 01 07                   [2] 03 05                       |\n" + 
            "|    [3] 01 02 05                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|    [q] Quit                                                    |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n";
        return screen;
    }
    public static final String end(int score, int level) {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n";
        if (score == 0) {
            screen += "" +
            "|                     >> Congradulations! <<                     |\n";
        } else {
            screen += "" +
            "|                        >> Game Over! <<                        |\n";
        }
        screen += "" +
            "|                                                                |\n";
        switch(level) {
            case 0:
                screen += "|    Difficulty: [-0-] Easy                        ";
                break;
            case 1:
                screen += "|    Difficulty: [-1-] Normal (OG)                 ";
                break;
            case 2:
                screen += "|    Difficulty: [-2-] Hard                        ";
                break;
            case 3:
                screen += "|    Difficulty: [-3-] Challenge                   ";
                break;
            case 4:
                screen += "|    Difficulty: [-4-] Nightmare                   ";
                break;
            case 5:
                screen += "|    Difficulty: [-5-] Impossible                  ";
                break;
            default:
                screen += "|    Difficulty: ???                               ";
                break;
        
        }
        screen += "" +
            "Score: " + score_format.format(score) + "    |\n" + 
            "|                                                                |\n" + 
            "|    Enter a 3 character name to save your score:                |\n" + 
            "|                                                                |\n" +  
            "|                             [---]                              |\n" + 
            "|                                                                |\n" + 
            "|    [b] No thanks, back to menu                                 |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" +
            "|                                                                |\n" +
            "|                                                                |\n" +
            "+----------------------------------------------------------------+\n";
        return screen;
    }
    public static final String leader_board(String[] top) {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|                       >> Leader Board <<                       |\n" + 
            "|       [-0-]    [-1-]    [-2-]    [-3-]    [-4-]    [-5-]       |\n" + 
            "|      ";

        for (int i = 0; i < 60; i++) { 
            if (i < top.length) {
                screen += top[i] + "  ";
            } else {
                screen += "--- ---  ";
            }
            if ((i+1) % 6 == 0) {
                screen += "    |\n|      ";
            }
            System.out.println(screen);
        }
        screen += "" + 
                   "                                                          |\n" + 
            "|    [b] Back                                                    |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n";
        return screen;
    }
}
