public class Test {
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) { total += num; }
        return total;
    }

    public static void runTests() {

        // Screen tests
        String[] top10 = {"mom 000", "dad 150", "sis 200", "bro 250"};

        int[] board5 = {
            1, 2, 3, 4, 5, 0, 7, 8, 0, 10, 11, 0, 13, 14, 15, 16, 17, 0, 19, 20, 0, 0, 23, 0, 
            25, 26, 0, 28, 0, 0, 31, 32, 0, 34, 35, 36
        };
        int[] dice5 = {1,5,6,2,4,3}; // 21
        String[] options5 = {
            "01 20", "02 19", "01 03 17", "04 17", "05 16", "07 14", "08 13",
            "01 03 07 10", "02 08 11", "02 04 07 08", "10 11", "01 07 13", "03 05 13" // 13
        };

        int[] board4 = {
            1, 2, 3, 4, 5, 0, 7, 8, 0, 10, 11, 0, 13, 14, 15, 16, 17, 0, 19, 20, 0, 0, 23, 0, 
            25, 26, 0, 28, 0, 0
        };
        int[] dice4 = {1,5,6}; // 12
        String[] options4 = {
            "01 20", "02 19", "01 03 17", "04 17", "05 16", "07 14", "08 13",
            "01 03 07 10", "02 08 11", "02 04 07 08", "10 11", "01 07 13" // 12
        };

        int[] board3 = {
            1, 2, 3, 4, 5, 0, 7, 8, 0, 10, 11, 0, 13, 14, 15, 16, 17, 0, 19, 20, 0, 0, 23, 0, 
        };
        int[] dice3 = {1,5,6,2}; // 14
        String[] options3 = {
            "01 20", "02 19", "01 03 17", "04 17", "05 16", "07 14", "08 13" // 7
        };
        

        int[] board2 = { 1, 2, 3, 4, 5, 0, 7, 8, 0, 10, 11, 0, 13, 14, 15, 16, 17, 0 };
        int[] dice2 = {1,5,6}; // 12
        String[] options2 = { "01 20", "02 19", "01 03 17", "04 17" }; // 4

        int[] board1 = { 1, 2, 3, 4, 5, 0, 7, 8, 0, 10, 11, 0 };
        int[] dice1 = {1,9}; // 6
        String[] options1 = {}; // 0

        int[] board0 = { 1, 2, 3, 4, 5, 0 };
        int[] dice0 = {1}; // 1
        String[] options0 = { "01 20" }; // 1

            // show main menu
        System.out.println(Screen.main_menu(""));
            // show level menu
        System.out.println(Screen.level_menu(""));

            // show in game example ({-0-})
        System.out.println(Screen.in_game(sum(board0), 0, board0, dice0, options0, ""));
            // show in game example ({-1-})
        System.out.println(Screen.in_game(sum(board1), 1, board1, dice1, options1, ""));
            // show in game example ({-2-})
        System.out.println(Screen.in_game(sum(board2), 2, board2, dice2, options2, ""));
            // show in game example ({-3-})
        System.out.println(Screen.in_game(sum(board3), 3, board3, dice3, options3, ""));
            // show in game example ({-4-})
        System.out.println(Screen.in_game(sum(board4), 4, board4, dice4, options4, ""));
            // show in game example ({-5-})
        System.out.println(Screen.in_game(sum(board5), 5, board5, dice5, options5, ""));

            // show end example (win)
        System.out.println(Screen.end(0, 3, 5, ""));  
            // show end example (lose)
        System.out.println(Screen.end(201, 7, 5, ""));  
            // show leader board example
        System.out.println(Screen.leader_board(top10, 1, ""));
            // show info (all)
        for (int i = 0; i <7 ; i++) {// including the 404 page
            System.out.println(Screen.info(i, ""));
        }
    }
}
