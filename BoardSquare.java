/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // generates squares for the board with their attributes
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public class BoardSquare {

    private boolean isSpaceEmpty;
    private Piece piece;
    private String color;
    private boolean teleportSquare;
    
    public BoardSquare(String color) {
        super();
        this.isSpaceEmpty =true;
        this.color = color;
        this.teleportSquare = false;
    }

    public Piece getPiece() {
        return this.piece;
    }
    public String getSquareColor() {
        return this.color;
    }
    public boolean isEmpty() {
        return this.isSpaceEmpty;
    }
    public void setTeleportSquare(boolean t){this.teleportSquare = t;}
    public boolean isTeleportSquare() {return this.teleportSquare; }
    public void setPiece(Piece s) {
        this.piece=s;
        this.isSpaceEmpty=false;
    }
    public Piece removePiece() {
        Piece tmp=this.piece;
        this.piece = null;
        this.isSpaceEmpty=true;
        return tmp;
    }

    @Override
    public String toString() {
        if(this.piece==null) {
            if (isTeleportSquare()) {
                return "=======";
            }
            else {
                return "-------";
            }
        }
        else return "-"+this.piece.toString()+"-";
    }


}
