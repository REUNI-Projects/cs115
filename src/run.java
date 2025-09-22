public class run {
    public static void main(String[] args) {
        Dice dice = new Dice(); // Initialize Dice
        for (int i = 0; i < 10; i++) {
            System.out.println("Dice rolled: " + dice.roll()); // Test Dice
        }
        

        if (args.length > 0) {
            if (args[0].equals("-t")) { Test.runTests(); } // Run Tests
            else if (true) {} // Let AI play
        } else {
            // Start Game
            STB game = new STB();
            game.run();
        }
    }
}
