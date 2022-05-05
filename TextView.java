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
        this.actionType = getUsersNextActionType();
        System.out.println("Enter the index for the From Row");
        this.row = getValidInt(0, game.setGameBoard().getNumRows()-1);
        System.out.println("Enter the index for the From Column");
        this.col = getValidInt(0, game.setGameBoard().getNumColumns()-1);
        System.out.println("Enter the index for the To Row");
        this.mRow = getValidInt(0, game.setGameBoard().getNumRows()-1);
        System.out.println("Enter the index for the From Column");
        this.mCol = getValidInt(0, game.setGameBoard().getNumColumns()-1);
    }

    public void updateView(GameS22 game) {
        System.out.println(game);
    }

    public void printEndOfGameMessage(GameS22 game) {
        System.out.println("Game has ended. " + game.getWinner() + " has won.");
    }
}
