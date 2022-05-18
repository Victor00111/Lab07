/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // abstract piece class
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;
    public Piece(char c, String s, boolean h, boolean o){
        this.symbol = c;
        this.teamColor = s;
        this.hidden = h;
        this.original = o;
    }
    public abstract void speak();
    public abstract boolean validMovePath(int fromSquareRow,int fromSquareCol, int toSquareRow,int toSquareCol);
    public abstract char getSymbol();
    public abstract boolean validSpawnPath(int x1, int y1, int x2, int y2);
    public abstract String getTeamColor();
    public abstract boolean isHidden();
    public abstract boolean isOriginal();
    public abstract void setHidden(boolean h);
    public abstract void setOriginal(boolean o);
    public abstract boolean canSpawn();
    public abstract Piece spawn();
    public String toString() {
        return (teamColor+" "+symbol);
    }

}
