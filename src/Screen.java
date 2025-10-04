import java.text.DecimalFormat;

public class Screen {
    static DecimalFormat ooo_format = new DecimalFormat("000");
    static DecimalFormat oo_format = new DecimalFormat("00");

    //
    private static String screen_blank = "" +
        "|                                                                |\n";
    private static String screen_top = "" +
        "+----------------------------------------------------------------+\n" + screen_blank;
    private static String screen_bottom = "" + screen_blank +
        "+----------------------------------------------------------------+\n";
    private static String screen_back = "" +
        "|   [<] Back                 [e] Exit                            |\n";
    private static String screen_back_next = "" +
        "|   [<] Back                 [e] Exit                 [>] Next   |\n";
    private static String screen_next = "" +
        "|                            [e] Exit                 [>] Next   |\n";

    // Different Screens -------------------------------------------------------------------------

    public static final String main_menu(String msg) {
        // Arg Validation
        if (msg == null) { msg = ""; }

        // Screen
        String screen = screen_top + 
            "|    █▀▀▀█ █   █ █   █ ▀▀█▀▀          █▀▀▀▄ █▀▀▀█ █   █   ▄      |\n" + 
            "|    ▀■■■▄ █■■■█ █   █   █     THE    █■■■█ █   █  █■█  ■■█■■    |\n" + 
            "|    █▄▄▄█ █   █ █▄▄▄█   █            █▄▄▄▀ █▄▄▄█ █   █   ▀      |\n" + 
            "|   ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀   |\n" + 
            screen_blank +  
            "|   [p] Play                                                     |\n" + 
            "|   [l] Leader Board                                             |\n" + 
            "|   [i] Info                                                     |\n" + 
            screen_blank + 
            "|   [e] Exit                                                     |\n" + 
            screen_blank + screen_blank + screen_blank + 
            "|                                                  by 7cevage    |\n" +
            screen_bottom + msg + "> ";
        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |    █▀▀▀█ █   █ █   █ ▀▀█▀▀          █▀▀▀▄ █▀▀▀█ █   █   ▄      |
    |    ▀■■■▄ █■■■█ █   █   █     THE    █■■■█ █   █  █■█  ■■█■■    |
    |    █▄▄▄█ █   █ █▄▄▄█   █            █▄▄▄▀ █▄▄▄█ █   █   ▀      |
    |   ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀   |
    |                                                                |
    |   [p] Play                                                     | 
    |   [l] Leader Board                                             | 
    |   [i] Info                                                     | 
    |                                                                | 
    |   [e] Exit                                                     | 
    |                                                                | 
    |                                                                | 
    |                                                                | 
    |                                                   by 7cevage   |
    |                                                                |
    +----------------------------------------------------------------+
 */
    public static final String level_menu(String msg) {
        // Arg Validation
        if (msg == null) { msg = ""; }

        // Screen
        String screen = screen_top + 
            "|                     >> Level Selection <<                      |\n" + screen_blank;
        for (int i = 1; i < S.Level.values().length; i++) {
            screen += "|   [" + i + "] " + S.Level.values()[i].get_name() + 
            screen_blank.substring(8 + S.Level.values()[i].get_name().length());
        }
        screen += screen_blank +
            "|   [e] Exit                                                     |\n" + 
            screen_blank + screen_blank + screen_blank + screen_blank +
            screen_bottom + msg + "> ";
        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |                     >> Level Selection <<                      |
    |                                                                |
    |   [0] {-0-} Easy                                               |
    |   [1] {-1-} Normal (OG)                                        |
    |   [2] {-2-} Hard                                               |
    |   [3] {-3-} Challenge                                          | 
    |   [4] {-4-} Nightmare                                          | 
    |   [5] {-5-} Impossible                                         | 
    |                                                                | 
    |   [e] Exit                                                     | 
    |                                                                | 
    |                                                                | 
    |                                                                | 
    |                                                                |
    |                                                                |
    +----------------------------------------------------------------+
 */
    public static final String in_game(GameBoard board, Dice dice, Options options, 
        String msg) {

        // Arg Validation
        if (msg == null) { msg = ""; }

        int score = board.get_score();
        int level = board.get_level();

        if (score < 0 ) { msg += S.Error.Err151.get_msg(); }
        if (level < 0 || level > 5) { msg += S.Error.Err153.get_msg(); }
        if (dice.get_count() > level + 1) { msg += S.Error.Err102.get_msg(); }  
        if (options.get_options().size() > 13) { msg += S.Error.Err202.get_msg(); } 
        if (options.get_options().size() < 1 || score == 0) { msg += S.Error.Err251.get_msg(); } 

        // Screen
        String screen = screen_top + "|   " + board.get_board_str()[0] + "    " + 
            dice.get_dice_str()[0] + "   |\n" + "|   " + board.get_board_str()[1] + 
            "    " + dice.get_dice_str()[1] + "   |\n" + "|   " + board.get_board_str()[2] + 
            "    " + dice.get_dice_str()[2] + "   |\n" + "|   " + board.get_board_str()[3] + 
            "    " + dice.get_dice_str()[3] + "   |\n" + "|   " + board.get_board_str()[4] + 
            "    " + dice.get_dice_str()[4] + "   |\n" + screen_blank;

        for (int i = 1; i < 12; i += 2) {
            screen += "|   " + options.get_option_string(i) + " " + 
                options.get_option_string(i+1) + "    |\n";
        }

        screen += screen_blank;
        if (options.get_options().size() > 12) {
            screen += "|   [x ~] Alt Ans                                     [e] Exit   |\n";
        } else {
            screen += "|                                                     [e] Exit   |\n";
        }
        screen += screen_bottom + msg + "> ";

        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |   +-------------------<S:435|T:00|{-5-}>+    + Dice:    21 +   |
    |   | 01 02 03 04 05 ██ 07 08 ██ 10 11 ██ |    | [1] [5] [6] |   |
    |   | 13 14 15 16 17 ██ 19 20 ██ ██ 23 ██ |    | [2] [4] [3] |   |
    |   | 25 26 ██ 28 ██ ██ 31 32 ██ 34 35 36 |    |             |   |
    |   +-------------------------------------+    + [r-] Roll # +   |
    |                                                                |
    |   [01] 01 20                   [02] 02 19                      |
    |   [03] 01 03 17                [04] 04 17                      |
    |   [05] 05 16                   [06] 07 14                      |
    |   [07] 08 13                   [08] 01 03 07 10                |
    |   [09] 02 08 11                [10] 02 04 07 08                |
    |   [11] 10 11                   [12] 01 07 13                   |
    |                                                                |
    |   [x ~] Alt Ans                                     [e] Exit   |
    |                                                                |
    +----------------------------------------------------------------+
 */
    public static final String end(GameBoard board, String msg) {
        // Arg Validation
        if (msg == null) { msg = ""; }

        int score = board.get_score();
        int level = board.get_level();
        int turn = board.get_turn();

        if (score < 0) { msg += S.Error.Err151.get_msg(); }
        if (turn < 1) { msg += S.Error.Err152.get_msg(); }
        if (level < 0 || level > 5) { msg += S.Error.Err153.get_msg(); }

        // Screen
        String screen = screen_top;

        if (score == 0) {
            screen += "|                     >> Congradulations! <<                     |\n";
        } else {
            screen += "|                        >> Game Over! <<                        |\n";
        }
        screen += screen_blank + "|   Difficulty: " + S.Level.values()[level+1].get_name() + 
            screen_blank.substring(16 + S.Level.values()[level+1].get_name().length(), 40);

        screen += "Score: " + ooo_format.format(score) + " | Turns: " + oo_format.format(turn) + 
            "   |\n" + screen_blank + 
            "|   Please enter a 3 character name to save your score:          |\n" + 
            screen_blank +  
            "|                             [---]                              |\n" + 
            screen_blank + 
            "|   [e] No thanks, Exit                                          |\n" + 
            screen_blank + screen_blank + screen_blank + screen_blank + screen_blank + 
            screen_bottom + msg + "> ";
        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |                     >> Congradulations! <<                     |
    |                                                                |
    |   Difficulty: {-0-} Easy              Score: 001 | Turns: 20   |
    |                                                                |
    |   Please enter a 3 character name to save your score:          |
    |                                                                |
    |                             [---]                              |
    |                                                                |
    |   [e] No thanks, Exit                                          |
    |                                                                |
    |                                                                |
    |                                                                |
    |                                                                |
    |                                                                |
    |                                                                |
    +----------------------------------------------------------------+
 */
    public static final String leader_board(int page, String msg) {
        // Arg Validation
        if (msg == null) { msg = ""; }

        if (page < 1 || page > 3) { msg += S.Error.Err404.get_msg(); }

        // Screen
        String screen = screen_top + 
            "|                       >> Leader Board <<                       |\n" + 
            "|          {-0-}    {-1-}    {-2-}    {-3-}    {-4-}    {-5-}    |\n";

        for (int i = 0; i < 5; i++) { 
            screen += LeaderBoard.get_rank(i + (page -1) * 5 + 1);
        }

        screen += screen_blank;
        if (page == 1) { screen += screen_next; }
        else if (page == 2) { screen += screen_back_next; }
        else { screen += screen_back; }

        screen += screen_bottom + msg + "> ";
        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |                       >> Leader Board <<                       |
    |          {-0-}    {-1-}    {-2-}    {-3-}    {-4-}    {-5-}    |
    |   01.     ---      ---      ---      ---      ---      ---     |
    |          ---/--   ---/--   ---/--   ---/--   ---/--   ---/--   |
    |   02.                                                          |
    |                                                                |
    |   03.                                                          |
    |                                                                |
    |   04.                                                          |
    |                                                                |
    |   05.                                                          |
    |                                                                |
    |                                                                |
    |                            [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                       >> Leader Board <<                       |
    |          {-0-}    {-1-}    {-2-}    {-3-}    {-4-}    {-5-}    |
    |   06.     ---      ---      ---      ---      ---      ---     |
    |          ---/--   ---/--   ---/--   ---/--   ---/--   ---/--   |
    |   07.                                                          |
    |                                                                |
    |   08.                                                          |
    |                                                                |
    |   09.                                                          |
    |                                                                |
    |   10.                                                          |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                       >> Leader Board <<                       |
    |          {-0-}    {-1-}    {-2-}    {-3-}    {-4-}    {-5-}    |
    |   11.     ---      ---      ---      ---      ---      ---     |
    |          ---/--   ---/--   ---/--   ---/--   ---/--   ---/--   |
    |   12.                                                          |
    |                                                                |
    |   13.                                                          |
    |                                                                |
    |   14.                                                          |
    |                                                                |
    |   15.                                                          |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                            |
    |                                                                |
    +----------------------------------------------------------------+
*/
    public static final String info(int page, String msg) {
        // Arg Validation
        if (msg == null) { msg = ""; }

        if (page < 1 || page > 6) { msg += S.Error.Err404.get_msg(); }

        // Screen
        String screen = screen_top + 
            "|                           >> Info <<                           |\n";
        switch(page) {
            case 1:
                screen += "" +
                "|   Buttons and Input:                                           |\n" +
                "|      [ ] is a button, typing the value inside and hit ENTER    |\n" +
                "|      in the terminal will trigger an action. It is not cap     |\n" +
                "|      sensitive. A '-' is like a wild card charactor and a      |\n" +
                "|      '~' is a wild card of any length.                         |\n" +
                screen_blank +
                "|   Under the Screen:                                            |\n" +
                "|      Under the screen, you can see your inputs next to the     |\n" +
                "|      '> '. And if there is an ERROR from the game, it will     |\n" +
                "|      appear below the screen above the '> '.                   |\n" +
                screen_blank;
                break;
            case 2:
                screen += "" +
                "|   Leader Board:                                                |\n" +
                "|      The leader board shows the top 10 scores recorded for     |\n" +
                "|      each difficulty level. The smaller the score the          |\n" +
                "|      better.                                                   |\n" +
                screen_blank +
                "|   Difficulty/Level:                                            |\n" +
                "|      {-1-} is the original with 2 dice and 12 tiles to shut.   |\n" +
                "|      {-0-} only has 1 die and 6 tiles and with each            |\n" +
                "|      difficulty level, 1 extra die and 6 extra tiles are       |\n" +
                "|      added up to 6 dice and 36 tiles.                          |\n" +
                screen_blank;
                break;
            case 3:
                screen += "" +
                "|   Game Board:                                                  |\n" +
                "|      +-------------------<S:435|T:00|{-5-}>+                   |\n" +
                "|      | 01 02 03 04 05 ██ 07 08 09 10 11 12 |                   |\n" +
                "|      | ██ ██ ██ ██ ██ ██                   |                   |\n" +
                "|      |                                     |                   |\n" +
                "|      +-------------------------------------+                   |\n" +
                "|      The top right corner of the board shows S: the current    |\n" +
                "|      score, T: current turn, and difficulty level. In the      |\n" +
                "|      board are the tiles you are trying to shut. If it is      |\n" +
                "|      shut, it is ██ otherwise you see its number 00. The       |\n" +
                "|      total number of tiles visible depends on the level.       |\n";
                break;
            case 4:
                screen += "" +
                "|   Dice Area:                                                   |\n" +
                "|      + Dice:    08 +   The 08 is the sum of the dice. [6] is   |\n" +
                "|      | [6] [2] [X] |   not a button but a die. '6' is the      |\n" +
                "|      | [_] [_] [_] |   value of the die. 'X' means you chose   |\n" +
                "|      |             |   not to use that die. '_' die is not     |\n" +
                "|      + [r-] Roll # +   available.                              |\n" +
                screen_blank +
                "|      [r-] Roll # button says if you type 'r' followed by a     |\n" +
                "|      number, that will be the number of dice used in the       |\n" +
                "|      next turn. Ex: r6 would set to roll 6 dice next turn.     |\n" +
                "|      The Player will be notified of any invalid inputs.        |\n";
                break;
            case 5:
                screen += "" +
                "|   Tiles to Shut::                                              |\n" +
                "|      Under the Game Board and Dice Area are the available      |\n" +
                "|      moves the Player can pick from. At most, 12 potential     |\n" +
                "|      options are displayed for the Player to pick from.        |\n" +
                screen_blank +
                "|      If there are more then 12 possible moves, the [x ~] Alt   |\n" +
                "|      Ans button will be made available. If the Player types    |\n" +
                "|      'x 01 02' as their input, the board will try to shut      |\n" +
                "|      tiles 01 and 02.                                          |\n" +
                screen_blank + screen_blank;
                break;
            case 6:
                screen += "" +
                "|   End:                                                         |\n" +
                "|      When you shut all the tiles, you will. If there are no    |\n" +
                "|      possible moves left and not all tiles are shut, You       |\n" +
                "|      lose.                                                     |\n" +
                screen_blank +
                "|      At the end of a game, the game will prompt you to enter   |\n" +
                "|      enter a 3 charactor name to save your score for the       |\n" +
                "|      leader board. Saving your score is optional.              |\n" +
                screen_blank + screen_blank + screen_blank;
                break;
            default:
                screen += screen_blank + screen_blank + screen_blank +
                "|                   █   █     █▀▀▀█     █   █                    |\n" +
                "|                   ▀■■■█     █   █     ▀■■■█                    |\n" +
                "|                       █     █▄▄▄█         █                    |\n" +
                screen_blank +
                "|                         Page Not Found                         |\n" +
                screen_blank + screen_blank + screen_blank;
                break;
        }

        screen += screen_blank;

        switch(page) {
            case 1:
                screen += screen_next;
                break;
            case 6:
                screen += screen_back;
                break;
            default:
                screen += screen_back_next;
                break;
        }

        screen += screen_bottom + msg + "> ";
        return screen;
    }
/*                                  ><
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |                                                                |
    |                                                                |
    |                                                                |
    |                   █   █     █▀▀▀█     █   █                    |
    |                   ▀■■■█     █   █     ▀■■■█                    |
    |                       █     █▄▄▄█         █                    |
    |                                                                |
    |                         Page Not Found                         |
    |                                                                |
    |                                                                |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   Buttons and Input:                                           |
    |      [ ] is a button, typing the value inside and hit ENTER    |
    |      in the terminal will trigger an action. It is not cap     |
    |      sensitive. A '-' is like a wild card charactor and a      |
    |      '~' is a wild card of any length.                         |
    |                                                                |
    |   Under the Screen:                                            |
    |      Under the screen, you can see your inputs next to the     |
    |      '> '. And if there is an ERROR from the game, it will     |
    |      appear below the screen above the '> '.                   |
    |                                                                |
    |                                                                |
    |                            [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   Leader Board:                                                |
    |      The leader board shows the top 10 scores recorded for     |
    |      each difficulty level. The smaller the score the          |
    |      better.                                                   |
    |                                                                |
    |   Difficulty/Level:                                            |
    |      {-1-} is the original with 2 dice and 12 tiles to shut.   |
    |      {-0-} only has 1 die and 6 tiles and with each            |
    |      difficulty level, 1 extra die and 6 extra tiles are       |
    |      added up to 6 dice and 36 tiles.                          |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   Game Board:                                                  |
    |      +-------------------<S:435|T:00|{-5-}>+                   |
    |      | 01 02 03 04 05 ██ 07 08 09 10 11 12 |                   |
    |      | ██ ██ ██ ██ ██ ██                   |                   |
    |      |                                     |                   |
    |      +-------------------------------------+                   |
    |      The top right corner of the board shows S: the current    |
    |      score, T: current turn, and difficulty level. In the      |
    |      board are the tiles you are trying to shut. If it is      |
    |      shut, it is ██ otherwise you see its number 00. The       |
    |      total number of tiles visible depends on the level.       |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   Dice Area:                                                   |
    |      + Dice:    08 +   The 08 is the sum of the dice. [6] is   |
    |      | [6] [2] [X] |   not a button but a die. '6' is the      |
    |      | [_] [_] [_] |   value of the die. 'X' means you chose   |
    |      |             |   not to use that die. '_' die is not     |
    |      + [r-] Roll # +   available.                              |
    |                                                                |
    |      [r-] Roll # button says if you type 'r' followed by a     |
    |      number, that will be the number of dice used in the       |
    |      next turn. Ex: r6 would set to roll 6 dice next turn.     |
    |      The Player will be notified of any invalid inputs.        |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   Tiles to Shut::                                              |
    |      Under the Game Board and Dice Area are the available      |
    |      moves the Player can pick from. At most, 12 potential     |
    |      options are displayed for the Player to pick from.        |
    |                                                                |
    |      If there are more then 12 possible moves, the [x ~] Alt   |
    |      Ans button will be made available. If the Player types    |
    |      'x 01 02' as their input, the board will try to shut      |
    |      tiles 01 and 02.                                          |
    |                                                                |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                 [>] Next   |
    |                                                                |
    +----------------------------------------------------------------+
    |                                                                |
    |                           >> Info <<                           |
    |   End:                                                         |
    |      When you shut all the tiles, you will. If there are no    |
    |      possible moves left and not all tiles are shut, You       |
    |      lose.                                                     |
    |                                                                |
    |      At the end of a game, the game will prompt you to enter   |
    |      enter a 3 charactor name to save your score for the       |
    |      leader board. Saving your score is optional.              |
    |                                                                |
    |                                                                |
    |                                                                |
    |                                                                |
    |   [<] Back                 [e] Exit                            |
    |                                                                |
    +----------------------------------------------------------------+
 */
}
