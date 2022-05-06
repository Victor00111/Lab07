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
public class Rules {
    //Not Done Yet!

    GameS22 game;
    int row1;
    int col1;
    int row2;
    int col2;
    char action;

    public boolean getValidAction(GameS22 game, int row1, int col1, int row2, int col2, char action){
        boolean tmp = false;
        //Simplify comparing main square
        Piece check = game.getGameBoard().getSpaces()[row1][col1].getPiece();


        //For checking pieces
        PieceBuzz Buzz = new PieceBuzz();
        PieceBlueHen Blue = new PieceBlueHen();
        PieceEvilMinion Evil = new PieceEvilMinion();
        PieceMinion Minion = new PieceMinion();
        //simplify checks
        Piece open = game.getGameBoard().getSpaces()[row2][col2].getPiece();
        boolean empty = game.getGameBoard().getSpaces()[row2][col2].isEmpty();
        Team other = game.getOpponentTeam();
        Team current = game.getCurrentTeam();



        if(!game.board.inBounds(row1, col1) || !game.board.inBounds(row2, col2) && !check.validMovePath(row1,col1,row2,col2)){
            tmp = false;
        }
        if(game.getCurrentTeam() != game.getOpponentTeam() && !game.isTurn(game.getCurrentTeam())){
            tmp = false;
        }
        else if(action == 'M'){
            if(open == null ){
                tmp = true;
            }
        }
        else if(action == 'S'){
            if(!check.equals(Buzz)){
                if(open == null){
                    tmp = true;
                }
            }

        }
        else if(action == 'R'){
            if(check.equals(Buzz)){
                if(open != null){
                    tmp = true;
                }
            }

        }
        else if(action == 'A'){
            if(check.equals(Buzz) && empty && check.canAttack()){
                //need to check other team and lazor

                    tmp = true;
            }
            if(check.equals(Blue) && empty){
                //need to check other team
                tmp = true;
            }
            if(check.equals(Evil) && empty && game.getGameBoard().getSpaces()[row2][col2].getPiece().equals(Minion) && check.canAttack()){
                //need to check other team hunger
                tmp = true;
            }

        }
        return tmp;
    }


}
