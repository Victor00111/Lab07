public abstract class ActionSpawn extends Action{
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
