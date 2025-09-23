public class S {
    enum Screen {
        main_menu,
        level_menu,
        in_game,
        in_game_alt,
        end_win,
        end_lose,
        leader_board_1,
        leader_board_2,
        leader_board_3,
        info_1,
        info_2,
        info_3,
        info_4,
        info_5,
        info_6
    }
    enum Error { // not longer then 64char
        //         "----------------------------------------------------------------"
        // STB Game Loop Errors
        Err001("ERR 001: ???\n"),

        // Component Errors
            // Dice Errors
        Err101("ERR 101: ???\n"),

            // Game Board Errors
        Err201("ERR 201: ???\n"),

            // Options Errors
        Err301("ERR 301: ???\n"),

        // Screen Errors
        Err401("ERR 401: impossible score detected...\n"),
        Err402("ERR 402: impossible level detected...\n"),
        Err403("ERR 403: impossible game board detected...\n"),

        Err404("ERR 404: page not found...\n"),

        Err405("ERR 405: options generation worked too hard...\n"),
        Err406("ERR 406: game should have ended...\n"),
        Err407("ERR 407: impossible dice face detected...\n"),
        Err408("ERR 408: option text overflow detected...\n"),
        Err409("ERR 409: too many dice detected...\n"),
        Err410("ERR 410: non-positive turn count detected...\n"),

        // Testing Errors
        Err501("ERR 501: ???\n");

        private String msg;
        Error(String msg) { this.msg = msg; }
        public String get_msg() { return msg; }
    }
    enum Level {
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
}
