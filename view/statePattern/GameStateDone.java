package view.statePattern;

import java.awt.Font;
import java.awt.Graphics2D;
import controller.App;
import view.AppWindow;

public class GameStateDone implements GameState
 {

    @Override
    public void goNext(AppWindow context) 
    {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow()
     {
        enableControlButtons();
        disableInputFields();
        refreshCanvas();
    }

    private void enableControlButtons() 
    {
        App.win.newGameButton.setEnabled(true);
        App.win.highLowButton.setEnabled(true);
        App.win.closerAwayButton.setEnabled(true);
    }

    private void disableInputFields() 
    {
        App.win.numberField.setEnabled(false);
        App.win.showKeyButton.setEnabled(false);
    }

    private void refreshCanvas()
    {
        App.win.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) 
    {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        drawEndGameMessages(g2);
    }

    private void drawEndGameMessages(Graphics2D g2)
     {
        String correctMessage = String.format("%d is correct! (Attempts = %d)",
        App.game.getKey(), App.game.getAttempts());
        String newGamePrompt = "Press <New Game> to Play Again!";
        
        g2.drawString(correctMessage, 50, 100);
        g2.drawString(newGamePrompt, 50, 150);
    }

}

