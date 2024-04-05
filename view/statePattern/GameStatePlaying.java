package view.statePattern;

import java.awt.Font;
import java.awt.Graphics2D;
import controller.App;
import model.NumberGuessGame;
import view.AppWindow;

public class GameStatePlaying implements GameState {

    @Override
    public void goNext(AppWindow context) {
        transitionToCompletedState(context);
    }

    private void transitionToCompletedState(AppWindow context) {
        context.setGameState(new GameStateDone());
    }

    @Override
    public void updateWindow() 
    {
        setupGameWindowForPlaying();
    }

    private void setupGameWindowForPlaying()
     {
        App.win.newGameButton.setEnabled(false);
        App.win.numberField.setEnabled(true);
        App.win.highLowButton.setEnabled(true);
        App.win.closerAwayButton.setEnabled(true);
        App.win.showKeyButton.setEnabled(true);
        App.win.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) 
    {
        renderGameStateOnCanvas(g2);
    }

    private void renderGameStateOnCanvas(Graphics2D g2) 
    {
        setupCanvasFont(g2);
        displayKeyIfRequired(g2);
        displayGuessFeedback(g2);
        displayProgressMessage(g2);
    }

    private void setupCanvasFont(Graphics2D g2) 
    {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
    }

    private void displayKeyIfRequired(Graphics2D g2) 
    {
        NumberGuessGame game = App.game;
        if (game.isShowKeyOn()) {
            String keyString = String.format("(Key: %d)", game.getKey());
            g2.drawString(keyString, 50, 150);
        }
    }

    private void displayGuessFeedback(Graphics2D g2)
     {
        NumberGuessGame game = App.game;
        String feedbackText = game.getGuess() >= 0 ? 
            String.format("Your guess: %d (Attempts: %d)", game.getGuess(), game.getAttempts()) : 
            "Enter your guess";
        g2.drawString(feedbackText, 50, 100);
    }

    private void displayProgressMessage(Graphics2D g2) {
        NumberGuessGame game = App.game;
        if (game.progressMessage != null) {
            g2.drawString(game.progressMessage, 100, 200);
        }



        
    }
}
