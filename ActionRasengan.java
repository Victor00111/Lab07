/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Abstract class that handles the Rasengan feature and extends to Action
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */

public class ActionRasengan extends Action {

    public ActionRasengan(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);
    }

    public void performAction() {
        this.game.getGameBoard().getSquares()[row][col].getPiece().speak();
        for(int i = mRow-1; i <= mRow+1; i++) {
            for (int j = mCol-1; j <= mCol+1; j++) {
                if(i >= 0 && i <= 7 && j >= 0 && j <= 7) {
                    if(this.game.getGameBoard().getSquares()[i][j].getPiece() != null) {
                        if (this.game.getGameBoard().getSquares()[i][j].getPiece().teamColor.equals(this.game.getOpponentTeam().teamColor)) {
                            this.game.getOpponentTeam().removePieceFromTeam(this.game.getGameBoard().getSpaces()[i][j].getPiece());
                            this.game.getGameBoard().getSpaces()[i][j].removePiece();
                        }
                    }
                }
            }
        }
        this.game.changeTurn();
    }
}
