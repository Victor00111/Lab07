/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Class that controls the attack action and extends to Action
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class ActionAttack extends Action {
    public ActionAttack(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);
    }
    @Override
    public void performAction() {
        if (!this.game.getGameBoard().getSquares()[row][col].getPiece().getTeamColor().equals(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece().getTeamColor())) {
            this.game.getGameBoard().getSquares()[row][col].getPiece().speak();
            //this.game.getGameBoard().getSquares()[row][col].getPiece().numAttacks++;
            this.game.getOpponentTeam().removePieceFromTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
            this.game.getGameBoard().getSquares()[mRow][mCol].removePiece();
            this.game.getGameBoard().getSquares()[mRow][mCol].setPiece(this.game.getGameBoard().getSquares()[row][col].getPiece());
            this.game.getGameBoard().getSquares()[row][col].removePiece();
        }
        else if (this.game.getGameBoard().getSquares()[row][col].getPiece().symbol == 'E' && this.game.getGameBoard().getSquares()[mRow][mCol].getPiece().symbol == 'M') {
            this.game.getGameBoard().getSquares()[row][col].getPiece().speak();
            this.game.getCurrentTeam().removePieceFromTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
            this.game.getGameBoard().getSquares()[mRow][mCol].removePiece();
            Piece newPiece = this.game.getGameBoard().getSquares()[row][col].getPiece().spawn();
            this.game.getCurrentTeam().addPieceToTeam(newPiece);
            this.game.getGameBoard().getSquares()[mRow][mCol].setPiece(newPiece);
        }
        this.game.changeTurn();
    }
}
