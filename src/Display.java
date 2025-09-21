import java.text.DecimalFormat;

public class Display {
    static DecimalFormat ooo_format = new DecimalFormat("000");
    static DecimalFormat oo_format = new DecimalFormat("00");

    public static final String main_menu(String msg) {
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
            "|    [i] Info                                                    |\n" + 
            "|                                                                |\n" + 
            "|    [e] Exit                                                    |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                  by 7cevage    |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }

    public static final String level_menu(String msg) {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|                   >> Difficulty Selection <<                   |\n" + 
            "|                                                                |\n" + 
            "|    [0] {-0-} Easy                                              |\n" + 
            "|    [1] {-1-} Normal (OG)                                       |\n" + 
            "|    [2] {-2-} Hard                                              |\n" +  
            "|    [3] {-3-} Challenge                                         |\n" + 
            "|    [4] {-4-} Nightmare                                         |\n" + 
            "|    [5] {-5-} Impossible                                        |\n" + 
            "|                                                                |\n" + 
            "|    [e] Exit                                                    |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }

    public static final String in_game(
            int score, int level, int[] board, int[] dice, String[] options, String msg
        ) {
        // Arg Validation
        int sum_score = 0;
        for (int tile : board) { sum_score += tile; }

        if (score < 0 || score != sum_score) { msg += "ERROR: impossible score detected...\n"; }
        if (level < 0 || level > 5) { msg += "ERROR: impossible level detected...\n"; }
        if (board.length > 36) { msg += "ERROR: impossible board detected...\n"; }
        if (dice.length > level + 1) { msg += "ERROR: too many dice detected...\n"; }  
        if (options.length > 13) { msg += "ERROR: option search tried too hard...\n"; } 
        if (options.length < 1) { msg += "ERROR: game should have ended...\n"; } 

        // Additional Setup
        int sum_dice = 0;
        for (int die : dice) { sum_dice += die; }

        String[] tiles = {"", "", ""};
        for (int i = 0; i < 36; i++) {
            if (i < board.length) {
                if (board[i] == 0) {
                    tiles[i/12] += "██ ";
                } else {
                    tiles[i/12] += oo_format.format(board[i]) + " ";;
                }
            } else {
                tiles[i/12] += "   ";
            }
        }

        String[] dice_face = new String[6];
        for (int i = 0; i < dice_face.length; i++) {
            if (i < dice.length) {
                dice_face[i] = dice[i] + "";
                // Additional Arg Validation
                if (dice[i] < 1 || dice[i] > 6) { 
                    msg += "ERROR: impossible dice face detected...\n"; 
                }
            } else if (i < level + 1) {
                dice_face[i] = "X";
            } else {
                dice_face[i] = "_";
            }
        }

        String options_list = "" +
            "|    [ ]                         [ ]                             |\n";
        //   |    [01] 01 02 03 04 05 06 07   [02] 01 02 03 04 05 06 07       |
        //   v    v    v    v    v    v    v    v    v    v    v    v    v    v
        //   0    5    10   15   20   25   30   35   40   45   50   55   60   65

        // Screen
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n";

        screen += "" + 
            "|    +--------------------<Score:" + ooo_format.format(score) + 
            "|{-" + level + "-}>+     Dice:    " + oo_format.format(sum_dice) + "     |\n" + 
            "|    | " + tiles[0] +                     "|     [" + dice_face[0] + "] [" + 
                                            dice_face[1] + "] [" + dice_face[2] + "]     |\n" + 
            "|    | " + tiles[1] +                     "|     [" + dice_face[3] + "] [" + 
                                            dice_face[4] + "] [" + dice_face[5] + "]     |\n" + 
            "|    | " + tiles[2] +                     "|                     |\n" + 
            "|    +-------------------------------------+    [d-] Dice opt    |\n" +  
            "|                                                                |\n";

        for (int i = 0; i < 12; i += 2) {
            // Additional Arg Validation
            if (i < options.length && options[i].length() >14) {
                msg += "ERROR: option text overflow detected...\n";
            }
            if (i + 1 < options.length && options[i + 1].length() >14) {
                msg += "ERROR: option text overflow detected...\n";
            }
            
            if (i + 1 < options.length) {
                screen += options_list.substring(0, 6) + oo_format.format(i + 1) +
                    options_list.substring(7, 9) + options[i] + 
                    options_list.substring(10 + options[i].length(),34) + oo_format.format(i + 2) +
                    options_list.substring(35, 37) + options[i + 1] +
                    options_list.substring(38 + options[i + 1].length());
            } else if (i < options.length) {
                screen += options_list.substring(0, 6) + oo_format.format(i + 1) +
                    options_list.substring(7, 9) + options[i] + 
                    options_list.substring(10 + options[i].length(),33) + "    " +
                    options_list.substring(37);
            } else {
                screen += options_list.substring(0, 5) + "    " +
                    options_list.substring(9, 33) + "    " +
                    options_list.substring(37);
            }
        }

        screen += "" + 
            "|                                                                |\n";

        if (options.length > 12) {
            screen += "|    [x ~] Alt Ans                                   [e] Exit    |\n";
        } else {
            screen += "|                                                    [e] Exit    |\n";
        }

        screen += "" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }

    public static final String end(int score, int level, String msg) {
        // Arg Validation
        if (score < 0) { msg += "ERROR: impossible score detected...\n"; }
        if (level < 0 || level > 5) { msg += "ERROR: impossible level detected...\n"; }

        // Screen
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
                screen += "|    Difficulty: {-0-} Easy                        ";
                break;
            case 1:
                screen += "|    Difficulty: {-1-} Normal (OG)                 ";
                break;
            case 2:
                screen += "|    Difficulty: {-2-} Hard                        ";
                break;
            case 3:
                screen += "|    Difficulty: {-3-} Challenge                   ";
                break;
            case 4:
                screen += "|    Difficulty: {-4-} Nightmare                   ";
                break;
            case 5:
                screen += "|    Difficulty: {-5-} Impossible                  ";
                break;
            default:
                screen += "|    Difficulty: ERROR                             ";
                break;
        
        }
        screen += "" +
                                  "Score: " + ooo_format.format(score) + "    |\n" + 
            "|                                                                |\n" + 
            "|    Enter a 3 character name to save your score:                |\n" + 
            "|                                                                |\n" +  
            "|                             [---]                              |\n" + 
            "|                                                                |\n" + 
            "|    [e] No thanks, Exit                                         |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" + 
            "|                                                                |\n" +
            "|                                                                |\n" +
            "|                                                                |\n" +
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }

    public static final String leader_board(String[] top, String msg) {
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|                       >> Leader Board <<                       |\n" + 
            "|       {-0-}    {-1-}    {-2-}    {-3-}    {-4-}    {-5-}       |\n" + 
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
        }

        screen += "" + 
                   "                                                          |\n" + 
            "|    [e] Exit                                                    |\n" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }

    public static final String info(int page, String msg) {
        // Arg Validation
        if (page < 1 || page > 6) { msg += "ERROR: page not found...\n"; }

        // Screen
        String screen = "" +              // ><
            "+----------------------------------------------------------------+\n" + 
            "|                                                                |\n" + 
            "|                           >> Info <<                           |\n" + 
            "|                                                                |\n";

        switch(page) {
            case 1:
                screen += "" +
                "|    Buttons and Input:                                          |\n" +
                "|        [ ] is a button, typing the value inside and hit        |\n" +
                "|        ENTER in the terminal will trigger an action. It is     |\n" +
                "|        not cap sensitive. A '-' is like a wild card            |\n" +
                "|        charactor and a '~' is a wild card of any length.       |\n" +
                "|                                                                |\n" +
                "|    Under the Screen:                                           |\n" +
                "|        Under the screen, you can see your inputs next to       |\n" +
                "|        the '> '. And if there is an ERROR from the game, it    |\n" +
                "|        will appear below the screen above the '> '.            |\n";
                break;
            case 2:
                screen += "" +
                "|    Leader Board:                                               |\n" +
                "|        The leader board shows the top 10 scores recorded       |\n" +
                "|        for each difficulty level. The smaller the score the    |\n" +
                "|        better.                                                 |\n" +
                "|                                                                |\n" +
                "|    Difficulty:                                                 |\n" +
                "|        {-1-} is the original with 2 dice and 12 tiles to       |\n" +
                "|        shut. {-0-} only has 1 die and 6 tiles and with each    |\n" +
                "|        difficulty level, 1 extra die and 6 extra tiles are     |\n" +
                "|        added up to 6 dice and 36 tiles.                        |\n";
                break;
            case 3:
                screen += "" +
                "|    Game Board:                                                 |\n" +
                "|        +--------------------<Score:072|{-2-}>+                 |\n" +
                "|        | 01 02 03 04 05 ██ 07 08 09 10 11 12 |                 |\n" +
                "|        | ██ ██ ██ ██ ██ ██                   |                 |\n" +
                "|        |                                     |                 |\n" +
                "|        +-------------------------------------+                 |\n" +
                "|        This is the game board, the top right corner shows      |\n" +
                "|        your current score and game difficulty level. In the    |\n" +
                "|        board are the tiles you are trying to shut, if it is    |\n" +
                "|        shut, it is ██ otherwise you see its number 00.         |\n";
                break;
            case 4:
                screen += "" +
                "|    Dice Area:                                                  |\n" +
                "|         Dice:    08     The 08 is the sum of the dice.         |\n" +
                "|         [6] [2] [X]     [6] is not a button but a die. '6'     |\n" +
                "|         [_] [_] [_]     is the value of the die. 'X' means     |\n" +
                "|        [d-] Dice opt    you chose not to use that die. '_'     |\n" +
                "|                         means that die is not available.       |\n" +
                "|                                                                |\n" +
                "|        [d-] is saying if you type d6, it will use 6 dice in    |\n" +
                "|        the next roll, if your input is invalid it will show    |\n" +
                "|        an ERROR message under the screen.                      |\n";
                break;
            case 5:
                screen += "" +
                "|    Tiles to Shut:                                              |\n" +
                "|        Under the Game Board and Dice Area are the available    |\n" +
                "|        moves the Player can pick from. At most, 12             |\n" +
                "|        potential options are displayed for the Player to       |\n" +
                "|        pick from. If there are more then 12 possible moves     |\n" +
                "|                                                                |\n" +
                "|        If there are more then 12 possible moves, the           |\n" +
                "|        [x ~] Alt Ans button will be made available. If the     |\n" +
                "|        Player types 'x 01 02' as their input, it would try     |\n" +
                "|        to shut tiles 01 and 02.                                |\n";
                break;
            case 6:
                screen += "" +
                "|    End:                                                        |\n" +
                "|        When you shut all the tiles, you will. If there are     |\n" +
                "|        no possible moves left and not all tiles are shut,      |\n" +
                "|        You lose.                                               |\n" +
                "|                                                                |\n" +
                "|        At the end of a game, the game will prompt you to       |\n" +
                "|        enter a 3 charactor name to save your score for the     |\n" +
                "|        leader board. Saving your score is optional.            |\n" +
                "|                                                                |\n" +
                "|                                                                |\n";
                break;
            default:
                screen += "" +
                "|                                                                |\n" +
                "|                                                                |\n" +
                "|                                                                |\n" +
                "|                   █   █     █▀▀▀█     █   █                    |\n" +
                "|                   ▀■■■█     █   █     ▀■■■█                    |\n" +
                "|                       █     █▄▄▄█         █                    |\n" +
                "|                                                                |\n" +
                "|                         Page Not Found                         |\n" +
                "|                                                                |\n" +
                "|                                                                |\n";
                break;
        }

        screen += "|                                                                |\n";

        switch(page) {
            case 1:
                screen += "|                            [e] Exit                [>] Next    |\n";
                break;
            case 6:
                screen += "|    [<] Back                [e] Exit                            |\n";
                break;
            default:
                screen += "|    [<] Back                [e] Exit                [>] Next    |\n";
                break;
        }

        screen += "" +
            "|                                                                |\n" + 
            "+----------------------------------------------------------------+\n" +
            msg +
            "> ";
        return screen;
    }
}
