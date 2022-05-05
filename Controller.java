/**
 * <h1>Lab 7 </h1>
 * 
 * <h2>CISC 181-40L Spring 2022</h2>
 * 
 * <h3>University of Delaware</h3>
 * 
 * <p>
 * // The controller class that handles the game
 * 
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 * 
 * @since (2022-05-05)
 */
import java.util.ArrayList;

public class Controller {

    protected GameS22 game;
    protected TextView text;

    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu", 0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",0,0, true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",0, 0,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",0, 0,0,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red", 0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",0, 0,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",0,0, true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",0, 0,0,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller() {
        this.game = setUpGameModel();
        this.text = new TextView();
        this.text.updateView(game);
    }

    public void carryOutAction(int row, int col, int mRow, int mCol, char actionType) {
        if (actionType == 'M' || actionType == 'm') {
            Action action = new ActionMove(game, row, col, mRow, mCol);
            action.performAction();
        }
        if (actionType == 'S' || actionType == 's') {
            Action action = new ActionSpawn(game, row, col, mRow, mCol);
            action.performAction();
        }
        if (actionType == 'R' || actionType == 'r') {
            Action action = new ActionRecruit(game, row, col, mRow, mCol);
            action.performAction();
        }
        if (actionType == 'A' || actionType == 'a') {
            Action action = new ActionAttack(game, row, col, mRow, mCol);
            action.performAction();
        }
    }

    public void playGame() {
        boolean gameHasEnded = false;
        boolean done = false;
        while(!gameHasEnded) {
            while(!done) {
                this.text.getNextPlayersAction(game);
                if (Rules.checkValidAction(game, text.getRow(), text.getCol(), text.getMRow(), text.getMCol(), text.getActionType())) {
                    done = true;
                }
            }
            this.carryOutAction(text.getRow(), text.getCol(), text.getMRow(), text.getMCol(), text.getActionType());
            this.text.updateView(game);
            if (game.isAWinner()) {
                gameHasEnded = true;
            }
            else {
                done = false;
            }
        }
        text.printEndOfGameMessage(game);
    }

    public static void main(Strings[] args) {
        Controller gameController = new Controller();
        gameController.playGame();
    }
}
