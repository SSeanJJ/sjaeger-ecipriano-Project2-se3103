package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import controller.App;

public class AppCanvas extends JPanel 
{

    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 100;

    public AppCanvas() {
        initializeCanvas();
    }

    private void initializeCanvas() {
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D graphics2D = (Graphics2D) g;

        delegateDrawingToGameState(graphics2D);
    }

    private void delegateDrawingToGameState(Graphics2D graphics2D) {
        App.win.getGameState().updateCanvas(graphics2D);
    }
}

