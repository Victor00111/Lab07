/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // generates the two dimension array for the board
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] spaces;

    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.spaces = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows(){
        return this.numRows;
    }
    public int getNumColumns(){
        return this.numColumns;
    }
    public BoardSquare[][] getSpaces(){
        return this.spaces;
    }

    public BoardSquare[][] getSquares(){
        return spaces;
    }
    public boolean inBounds(int rowIndex, int columnIndex){
        if (rowIndex > this.numRows-1 || columnIndex > this.numColumns-1){
            return false;
        }
        else if (rowIndex < 0 || columnIndex < 0){
            return false;
        }
        else{
            return true;
        }
    }
    public void setUpEmptyBoard(){
        for (int i = 0; i < this.numRows; i=i+2){
            for (int j = 0; j < this.numColumns; j++) {
                if (j % 2 == 0) {
                    BoardSquare blueSpace = new BoardSquare("blue");
                    spaces[i][j] = blueSpace;
                }
                else{
                    BoardSquare orangeSpace = new BoardSquare("yellow");
                    spaces[i][j] = orangeSpace;
                }
            }
        }
        for (int i = 1; i < this.numRows; i=i+2){
            for (int j = 0; j < this.numColumns; j++) {
                if (j % 2 == 0) {
                    BoardSquare orangeSpace = new BoardSquare("yellow");
                    spaces[i][j] = orangeSpace;
                }
                else{
                    BoardSquare blueSpace = new BoardSquare("blue");
                    spaces[i][j] = blueSpace;
                }
            }
        }
    }
    public BoardSquare findRandomEmptySpace(){
        int rowIndex = (int)(Math.random() * this.numRows);
        int columnIndex = (int)(Math.random() * this.numRows);
        while(!spaces[rowIndex][columnIndex].isEmpty()){
            rowIndex = (int)(Math.random() * this.numRows);
            columnIndex = (int)(Math.random() * this.numRows);
        }
        return spaces[rowIndex][columnIndex];
    }
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}