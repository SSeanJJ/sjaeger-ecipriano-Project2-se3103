package view.statePattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import controller.App;
import view.AppWindow;

public class GameStateInit implements GameState {

    @Override
    public void goNext(AppWindow context) 
    {
        transitionToPlayingState(context);
    }

    private void transitionToPlayingState(AppWindow context) 
    {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow() 
    {
        configureUIElements();
        refreshGameCanvas();
    }

    private void configureUIElements() 
    {
        App.win.newGameButton.setEnabled(true);
        App.win.numberField.setEnabled(false);
        App.win.highLowButton.setEnabled(true);
        App.win.closerAwayButton.setEnabled(true);
        App.win.showKeyButton.setEnabled(false);
    }

    private void refreshGameCanvas()
     {
        App.win.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) 
    {
        drawInitialInstructions(g2);
    }

    private void drawInitialInstructions(Graphics2D g2) 
    {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.BLUE);
        g2.drawString("Press <New game> to start", 50, 50);
    }
}
