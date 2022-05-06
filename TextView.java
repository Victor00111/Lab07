/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Text view of the game
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
import java.util.Scanner;

public class TextView {

    protected int row;
    protected int col;
    protected int mRow;
    protected int mCol;
    protected char actionType;

    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
    public int getMRow() {return this.mRow;}
    public int getMCol() {return this.mCol;}

    public static char getUsersNextActionType() {
        char userAction = 'N';
        boolean done = false;

        Scanner scr = new Scanner(System.in);
        while (!done) {
            System.out.println("Please enter either A, R, M, or S");
            char userInput = scr.next().charAt(0);
            char UpperFirstChar = Character.toUpperCase(userInput);
            if (UpperFirstChar == 'A' || UpperFirstChar == 'R' || UpperFirstChar == 'M' || UpperFirstChar == 'S') {
                userAction = userInput;
                done = true;
            }
            else {
                continue;
            }
        }
        return userAction;
    }

    public static int getValidInt(int minInt, int maxInt, Scanner scr) {
        int userInput = 0;
        int validInput = 0;
        boolean done = false;

        while(!done) {
            System.out.println("Please enter a number between " + minInt + " and " + maxInt);
            if (scr.hasNextInt()) {
                userInput = scr.nextInt();
                if (userInput < minInt || userInput > maxInt) {
                    continue;
                }
                else {
                    done = true;
                    validInput = userInput;
                }
            }
            else {
                scr.next();
            }

        }
        return validInput;
    }

    public void getNextPlayersAction(GameS22 game) {
        Scanner scr = new Scanner(System.in);
        this.actionType = getUsersNextActionType();
        System.out.println("Enter the index for the From Row");
        this.row = getValidInt(0, game.getGameBoard().getNumRows()-1,scr);
        System.out.println("Enter the index for the From Column");
        this.col = getValidInt(0, game.getGameBoard().getNumColumns()-1,scr);
        System.out.println("Enter the index for the To Row");
        this.mRow = getValidInt(0, game.getGameBoard().getNumRows()-1,scr);
        System.out.println("Enter the index for the From Column");
        this.mCol = getValidInt(0, game.getGameBoard().getNumColumns()-1,scr);
    }

    public void updateView(GameS22 game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(GameS22 game) {
        System.out.println("Game has ended. " + game.getWinner() + " has won.");
    }

}
