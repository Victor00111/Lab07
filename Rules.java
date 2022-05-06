/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Rules for the game and qualifications for actions
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
import java.util.ArrayList;

public class Rules {
    //Not Done Yet!

    GameS22 game;
    int row1;
    int col1;
    int row2;
    int col2;
    char action;

    public static boolean checkValidAction(GameS22 game, int row1, int col1, int row2, int col2, char action){
        boolean tmp = false;
        //Simplify comparing main square
        Piece check = game.getGameBoard().getSpaces()[row1][col1].getPiece();
        Piece otherPiece = game.getGameBoard().getSpaces()[row2][col2].getPiece();


        //For checking pieces
        PieceBuzz Buzz = new PieceBuzz();
        PieceBlueHen Blue = new PieceBlueHen();
        PieceEvilMinion Evil = new PieceEvilMinion();
        PieceMinion Minion = new PieceMinion();

        //simplify checks
        Team other = game.getOpponentTeam();
        Team current = game.getCurrentTeam();

        //To check can attacks
        PieceBuzz BuzzLasor = (PieceBuzz) game.getGameBoard().getSpaces()[row1][col1].getPiece();
        PieceEvilMinion EvilHunger = (PieceEvilMinion) game.getGameBoard().getSpaces()[row1][col1].getPiece();

        //Checking teams
        String currTeam = game.getCurrentTeam().getTeamColor();
        String oppTeam = game.getOpponentTeam().getTeamColor();
        String mainTeam = game.getGameBoard().getSpaces()[row1][col1].getSquareColor();
        String otherTeam = game.getGameBoard().getSpaces()[row2][col2].getSquareColor();




        if(!game.board.inBounds(row1, col1) || !game.board.inBounds(row2, col2) && !check.validMovePath(row1,col1,row2,col2)){
            tmp = false;
        }
        if(!current.equals(other) || !game.isTurn(game.getCurrentTeam())){
            tmp = false;
        }
        else if(action == 'M' && currTeam == mainTeam){
            if(otherPiece == null ){
                tmp = true;
            }
        }
        else if(action == 'S' && currTeam == mainTeam){
            if(!check.equals(Buzz)){
                if(otherPiece == null){
                    tmp = true;
                }
            }

        }
        else if(action == 'R' && currTeam == mainTeam){
            if(check.equals(Buzz)){
                if(otherPiece != null){
                    tmp = true;
                }
            }

        }
        else if(action == 'A'){
            if(check.equals(Buzz)  && BuzzLasor.canAttack()){
                if(oppTeam == otherTeam){
                    tmp = true;
                }
            }
            if(check.equals(Blue) && currTeam == mainTeam){
                if(oppTeam == otherTeam){
                    tmp = true;
                }
            }
            if(check.equals(Evil) && EvilHunger.canAttack()){
                if(otherPiece.equals(Minion) && oppTeam == mainTeam){
                    tmp = true;
                }
                else if(oppTeam == otherTeam){
                    tmp = true;
                }

            }

        }
        return tmp;
    }


}