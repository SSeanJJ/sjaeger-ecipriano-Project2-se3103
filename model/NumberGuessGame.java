package model;

import java.util.Random;

import model.strategyPattern.HighLowStrategy;
import model.strategyPattern.PlayStrategy;
import view.statePattern.GameState;

public class NumberGuessGame 
{
    public static final int MAX_KEY = 100;

    private int key;
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private GameState state;
    private PlayStrategy strategy;
    public String progressMessage;
    public int diff;

    public NumberGuessGame() 
    {
        key = -1;
        guess = -1;
        showKeyOn = false;
        attempts = 0;


        setStrategy(new HighLowStrategy(this));
    }

    public void start() 
    {
        key = generateNewKey();
        guess = -1;
        attempts = 0;
        progressMessage = null;
    }

    private int generateNewKey() 
    {
        Random r = new Random();
        int newKey;
        do 
        {
            newKey = r.nextInt(MAX_KEY + 1);
        } while (newKey == key);

        return newKey;
    }

    public void play(int guess) 
    {
        ++attempts;
        
        strategy.play(guess);
    }

    public int getAttempts() 
    {
        return attempts;
    }

    public void setAttempts(int attempts) 
    {
        this.attempts = attempts;
    }

    public boolean isShowKeyOn() 
    {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn)
    {
        this.showKeyOn = showKeyOn;
    }

    public GameState getState() 
    {
        return state;
    }

    public void setState(GameState state) 
    {
        this.state = state;
    }

    public PlayStrategy getStrategy()
     {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy) 
    {
        this.strategy = strategy;
    }

    public int getGuess()
    {
        return guess;
    }

    public void setGuess(int guess) 
    {
        this.guess = guess;
    }

    public int getKey() 
    {
        return key;
    }

    public void setDiff(int guess) 
    {
        this.diff = guess - key;
    }

    public int getDiff() 
    {
        return diff;
    }

    public void setProgressMessage(String progressMessage) 
    {
        this.progressMessage = progressMessage;
    }

    @Override
    public String toString() 
    {
        return String.format(
                "key(%d) guess (%d) attempts (%d)",
                key, guess, attempts);
    }

}
