public abstract class Action {

    GameS22 game;
    int row;
    int col;
    int mRow;
    int mCol;

    public Action(GameS22 game, int row, int col, int mRow, int mCol){
        this.game = game;
        this.row = row;
        this.col = col;
        this.mRow = mRow;
        this.mCol = mCol;
        return;
    }

    public abstract void performAction();

}
