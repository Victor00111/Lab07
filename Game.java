/**
 * <h1>Lab 7</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // UPDATED aspect of Game
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
import java.util.Collections;

public abstract class Game {
    protected GameBoard board;
    protected Team team1;
    protected Team team2;
    protected String turn;

    private void initializeGameBoard(int numRows, int numColumns){
        board = new GameBoard(numRows, numColumns);
        for (Piece piece : team1.teamPieces) {
            board.findRandomEmptySpace().setPiece(piece);
        }
        for (Piece piece : team2.teamPieces) {
            board.findRandomEmptySpace().setPiece(piece);
        }
        int teleportSquares = 0;
        while(teleportSquares < 2) {
            BoardSquare square = board.findRandomEmptySpace();
            if (!square.isTeleportSquare()) {
                square.setTeleportSquare(true);
                teleportSquares++;
            }
        }
    }

    public Game (int numRows, int numColumns, Team firstTeam, Team secondTeam){
        this.team1 = firstTeam;
        this.team2 = secondTeam;
        this.turn = firstTeam.getTeamColor();
        initializeGameBoard(numRows, numColumns);
    }

    public GameBoard getGameBoard(){
        return this.board;
    }

    public Team getCurrentTeam() {
        if (team1.getTeamColor().equals(turn)) {
            return team1;
        }
        else {
            return team2;
        }
    }

    public Team getOpponentTeam() {
        if (!(team1.getTeamColor().equals(turn))) {
            return team1;
        }
        else {
            return team2;
        }
    }
    public boolean isTurn(Team s){
        if(s.getTeamColor().equals(turn)){
            return true;
        }else{
            return false;
        }
    }

    public void changeTurn(){
        if(team1.getTeamColor().equals(turn)){
            turn = team2.getTeamColor();
        }else{
            turn = team1.getTeamColor();
        }
    }

    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();


    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }

}
