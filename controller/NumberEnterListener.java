
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.NumberGuessGame;

public class NumberEnterListener implements ActionListener
 {

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JTextField inputField = (JTextField) event.getSource();
        String inputText = inputField.getText();
        
        processGuess(inputText, inputField);
    }
    
    private void processGuess(String guessText, JTextField inputField) 
    {
        try {
            int guessNumber = Integer.parseInt(guessText);
            validateAndPlay(guessNumber, inputField);
        } catch (NumberFormatException ex)  {
            showErrorMessage("Please enter a valid integer.");
        }


    }
    
    private void validateAndPlay(int guess, JTextField inputField)
     {
        if (!isValidRange(guess))
        {
            showErrorMessage("Number must be between 0 and " + NumberGuessGame.MAX_KEY + ".");
            return;
        }

        App.game.play(guess);
        checkWinCondition(guess, inputField);
    }
    
    private boolean isValidRange(int number) 
    {
        return number >= 0 && number <= NumberGuessGame.MAX_KEY;
    }

    private void checkWinCondition(int guess, JTextField inputField) 
    
    {
        if (guess == App.game.getKey()) 
        {
            App.win.goNextState();
        }
        inputField.setText("");
        App.win.updateWindow();
    }

    private void showErrorMessage(String message) 

    {
        JOptionPane.showMessageDialog(App.win, message);
    }
}
