package model.strategyPattern;

import model.NumberGuessGame;

public class HighLowStrategy implements PlayStrategy
 {
    private NumberGuessGame game;

    public HighLowStrategy(NumberGuessGame game) 
    {
        this.game = game;
    }

    @Override
    public void play(int guess) 
    {
        updateGameWithGuess(guess);
        updateGameDifference(guess);
        provideFeedbackBasedOnDifference();
    }
    
    private void updateGameWithGuess(int guess) 
    {
        game.setGuess(guess);
    }
    
    private void updateGameDifference(int guess) 
    {
        game.setDiff(guess);
    }
    
    private void provideFeedbackBasedOnDifference() 
    {
        int difference = game.getDiff();
        if (difference < 0) 
        {
            game.setProgressMessage("Go higher!");
        } 
        else if (difference == 0) 
        {
            game.setProgressMessage("You got it! The key was " + game.getKey());
        } else {
            game.setProgressMessage("Go lower!");
        }

        
    }
}


