package tui;


/**
 * In this class the gameBoardLenght is set to an int. 
 * Initally an empty set of Strings is printed out. Nevertheless, a for loop is initiated
 * where the int i is first set to 0 and then incremented by 1 as long as it smaller than 
 * the gameBoardLength.This is then printed out and the same is done for the rows.
 * Eventually the char position is compared with the gameBoard row as well as column. 
 * If there is a ship the position as well as the type of the ship is printed out.
 *
 * @author bonezf@usi.ch, carlo.pederiva@usi.ch 
 * @version 0.5
 */
public class PrintGameBoardUtils {
    
    private PrintGameBoardUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Method printGameBoard prints the gameboard and the according chars of x 
     * when the game starts. It prints an * when a ship was discovered. When 
     * there is no ship, there is an empty blank space.
     *
     * @param gameBoard A parameter of x, * or empty blank space.
     */
    public static void printGameBoard(model.Coordinates[][] gameBoard) {
        System.out.print("   ");
        
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.print( + i + " ");
        }
        System.out.println();
        
        for (int row = 0; row < gameBoard.length; row++) {
            System.out.print(row + "  ");
            for (int col = 0; col < gameBoard.length; col ++) {
                model.Coordinates battleShip = gameBoard[row][col];
                if (battleShip.getShips() != null) {
                    int[] coords = new int[2];
                    coords[0] = row; 
                    coords[1] = col;
                    if (battleShip.getShips().hasBeenAttacked(coords)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("X ");
                    }
                } else {
                    if (battleShip.getIsUncoverd()) {
                        System.out.print("  ");
                    } else {
                        System.out.print("X ");
                    }

                }
            }
            System.out.println();
            
        }
        System.out.println();
        
    }
}
