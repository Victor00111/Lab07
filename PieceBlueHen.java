/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // piece bluehen class that extends to piece
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public class PieceBlueHen extends Piece implements Attacker, Recruiter{
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen (char symbol,
                         String teamColor,
                         int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    public char getSymbol() {
        return super.symbol;
    }
    public String getTeamColor() {
        return super.teamColor;
    }
    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }
    public boolean isHidden() {
        return super.hidden;
    }
    public boolean isOriginal() {
        return super.original;
    }
    public boolean canFly()    {
        return this.flies;
    }

    public void setSymbol(char symbol) {
        super.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        super.teamColor = teamColor;
    }

    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public boolean validAttackPath(int x1, int y1, int x2, int y2) {
        if(canFly()){
            return true;
        }else{
            if(x2== x1+1 || x2 == x1-1){
                return true;
            }else{
                return false;
            }
        }
    }

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int x1, int y1, int x2, int y2) {
        if(canFly()){
            return true;
        }else{
            if(y2== y1+1 || y2 == y1-1){
                return true;
            }else{
                return false;
            }
        }
    }

    public void setHidden(boolean hidden) {
        super.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        super.original = original;
    }

    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }
    public boolean isKing() {
        return this.king;
    }
    public void setKing(boolean t) {
        this.king = t;
    }
    public void speak(){
        System.out.println("Go UD!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        if(canFly()){
            return true;
        }else{
            if((fromSquareCol+1==toSquareCol || fromSquareCol-1==toSquareCol) && (fromSquareRow+1==toSquareRow || fromSquareRow-1==toSquareRow)){
                return true;
            }else{
                return false;
            }
        }
    }

    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen = new PieceBlueHen(Character.toLowerCase(super.symbol), super.teamColor,this.numAttacks,this.numRecruits, false,false);
        return copyHen;
    }
    public boolean validSpawnPath(int x1, int y1, int x2, int y2){
        if(canFly()){
            return true;
        }else{
            if((x2==x1+1 && y2 == y1+1)||(x2==x1+1 && y2 == y1-1)||(x2==x1-1 && y2 == y1+1)||(x2==x1-1 && y2 == y1-1)){
                return true;
            }else{
                return false;
            }
        }
    }
    public boolean canSpawn(){
        return true;
    }
}
