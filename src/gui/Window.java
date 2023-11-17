package gui;

import java.awt.Color; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Window class which is used to set up the game graphically for when the player is playing
 * the game. The size, title, operations are set and the boats created randomly.
 * Coloring is added when hitting an empty field or a boat. Message is added when you win the 
 * game. Options will be displayed what to do next.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.3
 */
public class Window extends JFrame {
    
    private JFrame window;
    private model.Coordinates[][] coordinates;
    private boolean gameover = false;

    /**
     * Window Constructor which creates a new window for the game.
     *
     * @param coordinates A parameter
     */
    public Window(model.Coordinates[][] coordinates) {
        super();
        this.coordinates = coordinates;
        window = new JFrame();
        window.setTitle("BattleShip"); 
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.BoatsUtils.addBoats();
        model.GameBoard gameBoard = new model.GameBoard(8, model.BoatsUtils.differentBoats);
        coordinates = gameBoard.createGameBoard();
        createGrid();
        window.setVisible(true);
    }
    
    /**
     * Method createGrid creates the visible grid on with JButtons.
     * If those are clicked they will turn of a specific color based 
     * on if a boat is present or not on that JButton.
     */
    public void createGrid() {
        window.setLayout(new GridLayout(8,8,2,2));        
        int pos = 1;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[0].length; j++) {
                final JButton btn = new JButton("" + pos);
                btn.setName(i + "-" + j);
                btn.setText(" ");
                btn.setForeground(Color.GRAY);
                btn.setOpaque(true);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent eve) {
                        String[] pos = btn.getName().split("-");
                        int coordi = Integer.parseInt(pos[0]);
                        int coordj = Integer.parseInt(pos[1]);
                        model.Coordinates target = coordinates[coordi][coordj];
                        if (target.getShips() == null) {
                            btn.setBackground(Color.BLUE);
                        } else if (target.getShips().hasBeenAttacked(new int[]{coordi,coordj})) {
                            btn.setBackground(Color.RED);
                        } else {
                            target.getShips().attackPosition(new int[]{coordi,coordj});
                            btn.setBackground(Color.RED);
                        }
                        if (model.TotalShipDestroyedUtils.totalShipsDestroyed(model.BoatsUtils.differentBoats)) {
                            Object[] options = {"OK"};
                            JOptionPane.showOptionDialog(null,
                                "You Won!","",
                                JOptionPane.PLAIN_MESSAGE,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                            gameover = true;
                            window.dispose();
                        }
                    }
                });
                pos++;
                window.add(btn);
            }
        }
    }
    
    /**
     * Method gameOver is used at the end of the game. If gameover is true, the 
     * window is disposed when selected.
     *
     * @return The return value true or false which is assigned to gameover a boolean.
     */
    public boolean gameOver() {
        return gameover;
    }
}
