public class run {
    public static void main(String[] args) {

        GameBoard game_board = new GameBoard(2); // Initialize Game Board
        System.out.println(
            game_board.get_board_str()[0] + "\n" +
            game_board.get_board_str()[1] + "\n" +
            game_board.get_board_str()[2] + "\n" +
            game_board.get_board_str()[3] + "\n" +
            game_board.get_board_str()[4] + "\n"
        );
        game_board.update_board(new int[]{1,5,7,8});
        System.out.println(
            game_board.get_board_str()[0] + "\n" +
            game_board.get_board_str()[1] + "\n" +
            game_board.get_board_str()[2] + "\n" +
            game_board.get_board_str()[3] + "\n" +
            game_board.get_board_str()[4] + "\n"
        );

        Dice dice = new Dice(); // Initialize Dice
        for (int i = 0; i < 10; i++) {
            dice.roll();
            System.out.println("Dice rolled: " + dice.get_face()); // Test Dice
        }
        
        // ---------------------------------------------------------------------------------------

        if (args.length > 0) {
            if (args[0].equals("-t")) { Test.runTests(); } // Run Tests
            else if (true) {} // Let AI play
        } else {
            // Start Game
            STB game = new STB();
            game.start();
        }
    }
}
