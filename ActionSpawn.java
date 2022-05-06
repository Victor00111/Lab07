/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Class that handles the spawn feature and extends to Action
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class ActionSpawn extends Action{
    public ActionSpawn(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);

    }

    public void performAction(){
        game.getGameBoard().getSpaces()[row][col].getPiece().speak();
        Piece spawn = game.board.getSpaces()[row][col].getPiece().spawn();
        game.getCurrentTeam().addPieceToTeam(spawn);
        game.getGameBoard().getSpaces()[mRow][mCol].setPiece(spawn);
        game.changeTurn();


        game.changeTurn();
    }

}
