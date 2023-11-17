package tui;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * The main class is used to execute the game itself. A gameboard is initiated with messages in 
 * order to start playing the game. The gameboard is an 8x8 frame. The ships will be placed 
 * randomly. Coordinates for row and column can be entered by using number 0-7. If the game 
 * finished, there is the option to choose if you want to let the AI play by following
 * the message which will appear.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.7
 */

public class Maintui {
        
    private static model.Coordinates[][] coordinates;
    private static int gameBoardLength = 8;
    private Scanner scanner;
    private static int attemptsP = 0;
    private static int attemptsAI = 0;
    
    /**
     * Maintui Constructor.
     *
     */
    public Maintui() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }
    
    /**
     * Method run which prints the message welcome to Battleship when the game is initiated.
     *
     */
    public void run() {
        System.out.println("Welcome to Battleship");
        while (true) {
            step();
        }
    }
    
    private void step() {
        char command = askCommand();
        if (command == 'c') {
            model.BoatsUtils.addBoats();
            model.GameBoard gameBoard = new model.GameBoard(gameBoardLength, model.BoatsUtils.differentBoats);
            coordinates = gameBoard.createGameBoard();
            game(1);
            System.out.println("Do you want to play against the AI to see who wins?(y/n):");
            command = scanner.next().charAt(0);
            if (command == 'y') {
                game(2);
                if (attemptsP > attemptsAI) {
                    System.out.println("AI Win");
                } else if (attemptsP < attemptsAI) {
                    System.out.println("Player Win");
                } else {
                    System.out.println("Tie");
                }
            }
        } else if (command == 'q') {
            System.exit(1);
        }
    }
    
    private char askCommand() {
        System.out.println("What would you like to do?");
        System.out.println("[c] Continue with the Game");
        System.out.println("[q] Quit the Game");
        final String commandString = scanner.next();
        return commandString.charAt(0);
    }
    
    private void game(int player) {
        
        System.out.println("Welcome Player!");
        System.out.println("You are playing battleship, input numbers from 0 to the length of the gameboard.");
        System.out.println("If numbers greater than the length of the board are given, you will get another chance to correct youself.");
        System.out.println("However, if a string is given the game will crash D:, so do not input string or symbols.");
        System.out.println();
        model.BoatsUtils.restoreBoats();
        model.Coordinates[][] coordinatesCopy = copyGameBoard(coordinates); 
        PrintGameBoardUtils.printGameBoard(coordinates);
        model.GameAI gameAI = new model.GameAI(coordinates.length);
        int attempts = 0;
        while (!model.TotalShipDestroyedUtils.totalShipsDestroyed(model.BoatsUtils.differentBoats)) {
            int[] guessCoords;
            if (player == 1) {
                guessCoords = GetUserCoordsUtils.getUserCoords(gameBoardLength);
            } else {
                guessCoords = gameAI.getCoords();
            }
            String locationViewUpdate = GetTargetUtils.getTarget(guessCoords, coordinatesCopy);
            System.out.println(locationViewUpdate);
            PrintGameBoardUtils.printGameBoard(coordinatesCopy);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception ex) { 
                System.out.println("e"); 
            }
            attempts++;
        }
        if (player == 1) {
            attemptsP = attempts;
        } else {
            attemptsAI = attempts;
        }
        System.out.print("Attempts:" + attempts + " ");
    }
    
    private model.Coordinates[][] copyGameBoard(model.Coordinates[][] coordinates) {
        model.Coordinates[][] copyCoords = new model.Coordinates[coordinates.length][];

        for (int i = 0; i < coordinates.length; ++i) {
            copyCoords[i] = new model.Coordinates[coordinates[i].length];
            for (int j = 0; j < copyCoords[i].length; ++j) {
                copyCoords[i][j] = coordinates[i][j].copy();
            }   
        }   
        return copyCoords;
    }
    
    /**
     * Method main which assigns Maintui M to new Maintui.
     *
     * @param args A parameter of type String.
     */
    public static void main(final String[] args) {
        final Maintui M = new Maintui();
        M.run();
    }
}
