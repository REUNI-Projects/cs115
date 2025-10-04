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
        err_msg += LeaderBoard.load_leader_board();
        
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
                        int lv = Integer.parseInt(input) - 1;
                        if (lv >= 0 && lv <= 5) {
                            game_board = new GameBoard(lv);
                            if (use_seed) { 
                                dice = new Dice(lv + 1, S.get_lv(lv), seed); 
                            } else { dice = new Dice(lv + 1, S.get_lv(lv)); }
                            dice.roll();
                            options.generate_options(game_board, dice);

                            cur_screen = S.Screen.in_game;
                        } else { err_msg += S.Error.Err001.get_msg(); }

                    } else if (input.equals("e")) { cur_screen = S.Screen.main_menu; } 
                    else { err_msg += S.Error.Err001.get_msg(); }
                    break;
                case in_game:
                    System.out.print(Screen.in_game(game_board, dice, options, err_msg));
                    if (options.get_options().size() < 1 || game_board.get_score() == 0) { // GG
                        cur_screen = S.Screen.end;
                        System.out.println("");
                        break;
                    }
                    turn_reset();

                    if (input.equals("e")) { 
                        cur_screen = S.Screen.main_menu; 
                        options.reset();
                    }
                    else if (input.contains("x ") && options.get_options().size() > 12) {
                        // Parse Alt Ans

                        
                        update(null); // Update board
                    } else {
                        switch (input) {
                            case "01": pick_opt(0); break;
                            case "02": pick_opt(1); break;
                            case "03": pick_opt(2); break;
                            case "04": pick_opt(3); break;
                            case "05": pick_opt(4); break;
                            case "06": pick_opt(5); break;
                            case "07": pick_opt(6); break;
                            case "08": pick_opt(7); break;
                            case "09": pick_opt(8); break;
                            case "10": pick_opt(9); break;
                            case "11": pick_opt(10); break;
                            case "12": pick_opt(11); break;
                            default: err_msg += S.Error.Err001.get_msg(); break;
                        }
                    }

                    break;
                case end:
                    System.out.print(Screen.end(game_board, err_msg)); turn_reset();
                    if (input.equals("e")) { cur_screen = S.Screen.main_menu; break; }
                    else if (input.length() == 3) {
                        LeaderBoard.update_leader_board(input, game_board.get_score(), 
                            game_board.get_turn(), S.get_lv(game_board.get_level()));
                        cur_screen = S.Screen.main_menu; break;
                    } else { err_msg += S.Error.Err004.get_msg(); }

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
                        case "<": cur_screen = S.Screen.leader_board_2; break;
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

    private boolean is_int(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }

    private void pick_opt(int opt_idx) {
        if (opt_idx < options.get_options().size()) {
            int[] closing_tiles = options.get_option(opt_idx).stream().mapToInt(Integer::intValue).toArray();
            update(closing_tiles);
        } else { err_msg += S.Error.Err001.get_msg(); }
    }

    private void update(int[] close) {
        game_board.update_board(close);
        options.reset();
        dice.roll();
        options.generate_options(game_board, dice);
    }
}