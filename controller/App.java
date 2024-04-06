
package controller;

import model.NumberGuessGame;
import view.AppWindow;
import javax.swing.JFrame;

public class App 

{
    public static final AppWindow win = new AppWindow();
    public static final NumberGuessGame game = new NumberGuessGame();

        
    public static void main(String[] args)
    
    {
        initializeWindow();
    }
    
    private static void initializeWindow() 
    
    {
        win.init();
       
        win.setTitle("Number Guess Game");
        setupWindowLocation();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();
        win.setVisible(true);
    }

    private static void setupWindowLocation()
    
    {
        win.setLocationRelativeTo(null); 
        win.setLocation(300, 200); 
    }
}

// This is just for the push of the sub folder
