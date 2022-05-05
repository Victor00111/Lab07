public abstract class ActionMove extends Action{

    public ActionMove(GameS22 game, int row, int col, int mRow, int mCol) {
        super(game, row, col, mRow, mCol);

    }
    public void performAction(){
        game.getGameBoard().getSpaces()[row][col].getPiece().speak();
        Piece tmp = game.getGameBoard().getSpaces()[row][col].getPiece();
        game.getGameBoard().getSpaces()[row][col].removePiece();
        game.getGameBoard().getSpaces()[mRow][mCol].setPiece(tmp);
        game.changeTurn();
    }
}
