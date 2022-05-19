public class PieceNaruto extends Piece implements Attacker, Recruiter{


    private int numAttacks;
    private int numRecruits;
    private int numClones;
    private boolean canClone;

    final public int MAX_NUM_SPAWNS = 3;

//Need to add in action, getters, setters, and check for clones
    public PieceNaruto(char symbol,
                  String teamColor,
                  int numAttacks, int numRecruits, int numClones,
                  boolean hidden, boolean original){
        super(symbol,teamColor,hidden,original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        this.numClones = numClones;

    }

    public PieceNaruto(){
        this('N',"NON",
                0,0,0,
                false,true);
    }

//Getters and setters probably need to add more
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
    public int getNumClones(){return  this.numClones;}

    public boolean isHidden() {
        return super.hidden;
    }
    public boolean isOriginal() {
        return super.original;
    }
    public boolean isKing() {
        return this.king;
    }
    public void setKing(boolean t) {
        this.king = t;
    }
    public void updateClone(){
        if(numClones == MAX_NUM_SPAWNS){
            this.canClone = false;
        }
        else{
            this.canClone = true;
        }
    }

    //Move, attack, spawn, and recruit path All done
    @Override
    public boolean validAttackPath(int x1, int y1, int x2, int y2) {
        boolean check = false;
        if(y2 == y1 + 1){
            if(x2 == x1 || x2 == x1-1 || x2 == y1+1){
                check = true;
            }
        }

        return check;
    }

    @Override
    public boolean validRecruitPath(int x1, int y1, int x2, int y2) {
        boolean check = false;
        if(y2 == y1-1){
            if(x2 == x1 || x2 == x1-1 || x2 == x1+1){
                check = true;
            }
        }
        return check;
    }

    public boolean validSpawnPath(int x1, int y1, int x2, int y2){
        boolean check = false;
        if(y1 == y2){
            if(x2 == x1-1 || x2== x1+1){
                check = true;
            }
        }
        return check;
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        boolean check = false;
        //Horse in chest movement
        if(toSquareCol == fromSquareCol + 2 || toSquareCol == fromSquareRow - 2){
            if(toSquareRow == fromSquareRow + 1 || toSquareRow == fromSquareRow - 1){
                check = true;
            }
        }
        else if(toSquareRow == fromSquareRow + 2 || toSquareRow == fromSquareRow - 2){
            if(toSquareCol == fromSquareCol + 1 || toSquareCol == fromSquareRow - 1){
                check = true;
            }
        }

        return check;
    }

    public boolean canRasengan(int x1, int y1, int x2, int y2){
        boolean check = false;
        if(y1 == y2 && x1 != x2){
            check = true;
        }
        if(x1 == x2 && y1 != y2){
            check = true;
        }
        return check;
    }


    //Implement clone may need to change
    public PieceNaruto clone(){
        PieceNaruto clone = new PieceNaruto(Character.toLowerCase(super.symbol),
                super.teamColor,this.numAttacks,this.numRecruits, this.numClones,
                false,false);
        updateClone();
        return clone;
    }
}
