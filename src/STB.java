import java.util.Scanner;

public class STB {
    // Attributes
    private S.Screen cur_screen = S.Screen.off;
    private String input = "";
    private Scanner scan = new Scanner(System.in);

    private GameBoard game_board;
    private Dice dice;
    private Options options = new Options();
    private String err_msg = "";

    private boolean use_seed = false;
    private int seed = 0;

    public STB() { cur_screen = S.Screen.main_menu; }
    public STB(int new_seed) { 
        cur_screen = S.Screen.main_menu; 
        seed = new_seed; use_seed = true; 
    }

    // Game
    public void start() {
        System.out.println("Loading STB+ ...");

        
        // Game Loop
        do {
            switch (cur_screen) {
                case main_menu:
                    System.out.print(Screen.main_menu(err_msg)); turn_reset();
                    switch (input) {
                        case "p": cur_screen = S.Screen.level_menu; break;
                        case "l": cur_screen = S.Screen.leader_board_1; break;
                        case "i": cur_screen = S.Screen.info_1; break;
                        case "e": cur_screen = S.Screen.off; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case level_menu:
                    System.out.print(Screen.level_menu(err_msg)); turn_reset();
                    if (is_int(input)) {
                        int lv = Integer.parseInt(input);
                        if (lv >= 0 && lv <= 5) {
                            game_board = new GameBoard(lv);
                            if (use_seed) { 
                                dice = new Dice(lv + 1, S.get_lv(lv), seed); 
                            } else { dice = new Dice(lv + 1, S.get_lv(lv)); }
                            options.generate_options(game_board, dice);

                            cur_screen = S.Screen.in_game;
                        } else { err_msg += S.Error.Err001.get_msg(); }

                    } else if (input == "e") { cur_screen = S.Screen.main_menu; } 
                    else { err_msg += S.Error.Err001.get_msg(); }
                    break;
                case in_game:
                    System.out.print(Screen.in_game(game_board, dice, options, err_msg));
                    turn_reset();

                    break;
                case end:
                    System.out.print(Screen.end(game_board, err_msg));
                    turn_reset();
                    break;
                case leader_board_1:
                    System.out.print(Screen.leader_board(1, err_msg)); turn_reset();
                    switch (input) {
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.leader_board_2; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case leader_board_2:
                    System.out.print(Screen.leader_board(2, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.leader_board_1; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.leader_board_3; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case leader_board_3:
                    System.out.print(Screen.leader_board(3, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.leader_board_1; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_1:
                    System.out.print(Screen.info(1, err_msg)); turn_reset();
                    switch (input) {
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.info_2; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_2:
                    System.out.print(Screen.info(2, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.info_1; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.info_3; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_3:
                    System.out.print(Screen.info(3, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.info_2; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.info_4; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_4:
                    System.out.print(Screen.info(4, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.info_3; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.info_5; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_5:
                    System.out.print(Screen.info(5, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.info_4; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        case ">": cur_screen = S.Screen.info_6; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case info_6:
                    System.out.print(Screen.info(6, err_msg)); turn_reset();
                    switch (input) {
                        case "<": cur_screen = S.Screen.info_5; break;
                        case "e": cur_screen = S.Screen.main_menu; break;
                        default: err_msg += S.Error.Err001.get_msg(); break;
                    }
                    break;
                case off: break;
                default:
                    System.out.print(Screen.info(0, err_msg + S.Error.Err404.get_msg())); 
                    turn_reset(); cur_screen = S.Screen.main_menu; break;
            }

        } while (cur_screen != S.Screen.off);

        System.out.println("Exiting STB+ ...");
    }

    // Helpers
    private void turn_reset() { err_msg = ""; input = scan.nextLine();}

    static boolean is_int(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }
}