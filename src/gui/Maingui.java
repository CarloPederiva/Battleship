package gui;

import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 * Main GUI class.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.2
 */
public class Maingui {
    
    /**
     * Method run runs the gui and let's the player decide to play the AI or 
     * the actual player.
     *
     */
    public void run() {
        int res = 0;
        while (res != 3) {
            String[] options = {"Play player", "Play AI", "Exit"};
            res = JOptionPane.showOptionDialog(null, "Select one option:", "Play Battleship", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            model.BoatsUtils.addBoats();
            model.GameBoard gameBoard = new model.GameBoard(8, model.BoatsUtils.differentBoats);
            model.Coordinates[][] coordinates = gameBoard.createGameBoard();
            System.out.println(coordinates[0]);
            if (res == 0) {
                Window winP = new Window(coordinates);
                while (!winP.gameOver()) {
                    sleep(500);                
                }
            } else if (res == 1) {
                WindowAI winA = new WindowAI(coordinates);
                while (!winA.gameOver()) {
                    sleep(500);                
                }
            } else {
                System.exit(0);
            }
        }
    }
    
    private void sleep(int slp) {
        try {
            TimeUnit.MILLISECONDS.sleep(slp);
        } catch (Exception ex) {
            System.out.print("ex");
        }
    }
    
    /**
     * Method main starts the gui by using the method run(). 
     *
     * @param args are the arguments.
     */
    public static void main(final String[] args) {
        final Maingui M = new Maingui();
        M.run();
    }
}
