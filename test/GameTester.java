package test;

import model.NumberGuessGame;

public class GameTester
 {

    public static void main(String[] args) 
    {
        NumberGuessGame game = initializeGame();
       
        performInitialTest(game);
        performRepeatedGuessTest(game, 50);
        performRepeatedGuessTest(game, 50);
    }

    private static NumberGuessGame initializeGame() 
    {
        NumberGuessGame game = new NumberGuessGame();
        game.start();
        displayGameState(game);
        
        return game;
    }

    private static void performInitialTest(NumberGuessGame game) 
    {
        game.play(50);
        displayGameProgress(game);
    }

    private static void performRepeatedGuessTest(NumberGuessGame game, int guess) 
    {
        game.play(guess);
        displayGameProgress(game);
    }

    private static void displayGameState(NumberGuessGame game) 
    {
        System.out.println(game);
    }

    private static void displayGameProgress(NumberGuessGame game)
    {
        System.out.println(game);
        System.out.println(game.progressMessage);
    }
}
