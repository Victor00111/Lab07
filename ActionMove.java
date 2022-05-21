/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Abstract class that handles the move feature and extends to Action
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class ActionMove extends Action{

    public ActionMove(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);

    }
    public void performAction(){
        game.getGameBoard().getSpaces()[row][col].getPiece().speak();
        Piece tmp = game.getGameBoard().getSpaces()[row][col].getPiece();
        game.getGameBoard().getSpaces()[row][col].removePiece();
        game.getGameBoard().getSpaces()[mRow][mCol].setPiece(tmp);
        if(game.getGameBoard().getSpaces()[mRow][mCol].isTeleportSquare()) {
            for (int i = 0; i < game.getGameBoard().getNumRows(); i++) {
                for (int j = 0; j < game.getGameBoard().getNumColumns(); j++) {
                    if (game.getGameBoard().getSpaces()[i][j].isTeleportSquare() && game.getGameBoard().getSpaces()[i][j] != game.getGameBoard().getSpaces()[mRow][mCol]) {
                        game.getGameBoard().getSpaces()[i][j].setPiece(tmp);
                        game.getGameBoard().getSpaces()[mRow][mCol].removePiece();
                    }
                }
            }
        }
        game.changeTurn();
    }
}
