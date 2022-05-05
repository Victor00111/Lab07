public class ActionRecruit extends Action {

    public ActionRecruit(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);
    }

    @Override
    public void performAction() {
        this.game.getGameBoard().getSquares()[row][col].getPiece().speak();
        this.game.getOpponentTeam.removePieceFromTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
        this.game.getCurrentTeam.addPieceToTeam(this.game.getGameBoard().getSquares()[mRow][mCol].getPiece());
        this.game.changeTurn();
    }
}
