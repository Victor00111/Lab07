/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Class that handles the recruit function and extends action
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);
    }

    @Override
    public void performAction() {
        this.game.getGameBoard().getSquares()[row][col].getPiece().speak();
        this.game.getOpponentTeam().removePieceFromTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
        this.game.getCurrentTeam().addPieceToTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
        this.game.changeTurn();
    }
}
