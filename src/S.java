public class S {
    enum Screen {
        off,
        main_menu,
        level_menu,
        in_game,
        end,
        leader_board_1,
        leader_board_2,
        leader_board_3,
        info_1,
        info_2,
        info_3,
        info_4,
        info_5,
        info_6,
        err404
    }
    enum Error { // not longer then 64char
        //         "----------------------------------------------------------------"
        // User input (external)
        Err001("ERR 001: input, not a listed option\n"),
        Err002("ERR 002: input, invalid dice amount\n"),
        Err003("ERR 003: input, Alt Ans provided was unavailable\n"),
        Err004("ERR 004: input, name needs to be 3 characters\n"),

        // File IO Errors
        Err051("ERR 051: data, failed to read\n"),
        Err052("ERR 051: data, failed to update\n"),

        // Dice Errors
        Err101("ERR 101: dice, impossible face value\n"),
        Err102("ERR 102: dice, too many dice\n"),

        // Game Board Errors
        Err151("ERR 151: game board, impossible score value\n"),
        Err152("ERR 152: game board, impossible turn value\n"),
        Err153("ERR 153: game board, impossible level value\n"),
        Err154("ERR 154: game board, invalid game board\n"),

        // Options Errors
        Err201("ERR 201: options, text overflow\n"),
        Err202("ERR 202: options, generator overheated\n"),

        // Game Loop Errors
        Err251("ERR 251: loop, game should have ended\n"),

        // Screen Errors
        Err404("ERR 404: page not found...\n"),

        // Testing Errors
        Err501("ERR 501: ???\n");

        private String msg;
        Error(String msg) { this.msg = msg; }
        public String get_msg() { return msg; }
    }
    enum Level {
        L_("{-?-} Err", -1),
        L0("{-0-} Easy", 0),
        L1("{-1-} Normal (OG)", 1),
        L2("{-2-} Hard", 2),
        L3("{-3-} Challenge", 3),
        L4("{-4-} Nightmare", 4),
        L5("{-5-} Impossible", 5);

        private String name;
        private int num;
        Level(String name, int num) { 
            this.name = name; 
            this.num = num;
        }
        public String get_name() { return name; }
        public int get_num() { return num; }
    }
    public static Level get_lv(int lv) {
        switch (lv) {
            case 0: return Level.L0;
            case 1: return Level.L1;
            case 2: return Level.L2;
            case 3: return Level.L3;
            case 4: return Level.L4;
            case 5: return Level.L5;
            default: return Level.L_;
        }
    }
}
