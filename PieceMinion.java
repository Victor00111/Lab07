/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Minion piece class
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public class PieceMinion extends Piece implements Recruiter{
    private int numRecruits;
    private int numTimesSpawned;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor, int numRecruits, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol,teamColor,hidden,original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -", 0,0, false,true);
    }

    public char getSymbol() {
        return super.symbol;
    }
    public String getTeamColor() {
        return super.teamColor;
    }
    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }
    public boolean isHidden() {
        return super.hidden;
    }
    public boolean isOriginal() {
        return super.original;
    }

    public void setHidden(boolean hidden) {
        super.hidden = hidden;
    }
    public void setOriginal(boolean original){
        super.original = original;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int x1, int y1, int x2, int y2) {
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }

    public void speak(){
        System.out.println("Bello!");
    }

    public boolean validMovePath(int x1, int y1, int x2, int y2) { // any values up or down but in same x value
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }

    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(super.symbol),
                super.teamColor,1,
                0,
                false,
                false);
    }

    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

    public boolean validSpawnPath(int x1, int y1, int x2, int y2){
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }

}
