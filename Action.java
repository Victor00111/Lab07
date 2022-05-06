/**
 * <h1>Lab 7</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Abstract class for Action which sets the perform action.
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
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
