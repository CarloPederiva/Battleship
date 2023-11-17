package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class duplicates the initial window for the AI in order to let it play.
 * 
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */
public class WindowAI {
    private JFrame window;
    private JButton[][] buttons;
    private model.Coordinates[][] coordinates;
    private boolean gameover = false;
    
    /**
     * WindowAI Constructor which construct the window with the frame, the size, title,
     * close operation and the run game possibility.
     *
     * @param coordinates A parameter of type Coordinates.
     */
    public WindowAI(model.Coordinates[][] coordinates) {
        super();
        this.coordinates = coordinates;
        window = new JFrame();
        window.setTitle("BattleShipAI"); 
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runGame();
    }
    
    /**
     * Method runGame which makes it possible to run the game for the AI.
     *
     */
    private void runGame() {
        window.getContentPane().removeAll();
        model.BoatsUtils.restoreBoats();
        buttons = new JButton[8][8];
        createGridAI();
        window.setVisible(true);
        runAI();
    }
    
    /**
     * Method createGrid creates a new layout with the passed in sizes. Also the 
     * buttons, colors of when a field was chosen is defined.
     *
     */
    public void createGridAI() {
        window.setLayout(new GridLayout(8,8,2,2));        
        int pos = 1;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                final JButton btn = new JButton("" + pos);
                buttons[i][j] = btn;
                btn.setText("");
                btn.setForeground(Color.GRAY);
                btn.setOpaque(true);
                pos++;
                window.add(btn);
            }
        }
    }
    
    /**
     * Method runAI let's the AI run with a delay of 500 ms to see which position
     * was chosen. Also the color of the fields will be adjusted accordingly.
     *
     */
    private void runAI() {
        int att = 0;
        while (!model.TotalShipDestroyedUtils.totalShipsDestroyed(model.BoatsUtils.differentBoats)) {
            
            model.GameAI gameAI = new model.GameAI(coordinates.length);
            int[] coordsAI = gameAI.getCoords();
            int coordsI = coordsAI[0];
            int coordsJ = coordsAI[1];
            JButton btn = buttons[coordsI][coordsJ];
            if (btn.isEnabled()) {
                att++; 
            }
            model.Coordinates target = coordinates[coordsI][coordsJ];
            if (target.getShips() == null) {
                btn.setBackground(Color.BLUE);
            } else if (target.getShips().hasBeenAttacked(new int[]{coordsI,coordsJ})) {
                btn.setBackground(Color.RED);
            } else {
                target.getShips().attackPosition(new int[]{coordsI,coordsJ});
                btn.setBackground(Color.RED);
            }
            
            btn.setEnabled(false);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception ex) {
                System.out.print("ex");
            }
        }
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null,
            "AI ended in " + att + " attempts","",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
        gameover = true;
    }
    
    /**
     * Method gameOver is used to dispose the game window when selected.
     *
     * @return The return value which is either true or false and 
     *         assigned to gameover which is a boolean.
     */
    public boolean gameOver() {
        return gameover;
    }
}
