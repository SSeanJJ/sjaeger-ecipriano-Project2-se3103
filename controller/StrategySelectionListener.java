
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.strategyPattern.CloserAwayStrategy;
import model.strategyPattern.HighLowStrategy;
import view.AppWindow;

public class StrategySelectionListener implements ActionListener 
{

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        selectStrategyBasedOnAction(event.getActionCommand());
    }
    
    private void selectStrategyBasedOnAction(String actionCommand) 
    {
        switch (actionCommand) 
        {
            case AppWindow.highLowAction:
                applyHighLowStrategy();
                break;
            case AppWindow.closerAwayAction:
                applyCloserAwayStrategy();
                break;
            default:
                break;
        }
    }

    private void applyHighLowStrategy()
    {
        App.game.setStrategy(new HighLowStrategy(App.game));
    }
    
    private void applyCloserAwayStrategy() 
    {
        App.game.setStrategy(new CloserAwayStrategy(App.game));
    }

}

