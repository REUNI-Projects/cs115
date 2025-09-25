public class run {
    public static void main(String[] args) {

        
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
