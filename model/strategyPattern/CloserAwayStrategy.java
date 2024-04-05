package model.strategyPattern;

import model.NumberGuessGame;

public class CloserAwayStrategy implements PlayStrategy 
{
    private NumberGuessGame game;

    public CloserAwayStrategy(NumberGuessGame game) 
    {
        this.game = game;
    }

    @Override
    public void play(int guess) 
    {
        int previousDifference = calculatePreviousDifference();
        updateGameStateWithGuess(guess);
        int currentDifference = calculateCurrentDifference(guess);
        
        updateProgressBasedOnDifference(previousDifference, currentDifference);
    }
    
    private int calculatePreviousDifference() 
    {
        return game.getDiff();
    }
    
    private void updateGameStateWithGuess(int guess) 
    {
        game.setGuess(guess);
    }
    
    private int calculateCurrentDifference(int guess) 
    {
        return Math.abs(game.getKey() - guess);
    }
    
    private void updateProgressBasedOnDifference(int prevDiff, int newDiff) 
    {
        if (newDiff < prevDiff) 
        {
            game.setProgressMessage("Getting closer");
        } else {
            game.setProgressMessage("Not getting close");
        }
        game.setDiff(newDiff);



        
    }
}
