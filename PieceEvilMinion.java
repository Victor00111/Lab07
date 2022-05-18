/**
 * <h1>Lab5</h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Evil minion class that extends minion piece
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-04-13)
 */
public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter{
    private int numAttacks;
    private boolean hungry;
    public static int MAX_ATTACK = 4;
    public PieceEvilMinion(char c, String s, int nR, int nA, int nTS, boolean h, boolean o){
        super(c,s,nR,nTS,h,o);
        this.numAttacks = nA;
        updateHungry();
    }
    public PieceEvilMinion(){
        super('E',"NON",0,0,false,true);
        this.numAttacks = 0;
    }
    public int getNumAttacks(){
        return this.numAttacks;
    }
    public boolean canAttack(){
        return this.hungry;
    }
    public void setNumAttacks(int nA){
        this.numAttacks = nA;
    }

    @Override
    public boolean validAttackPath(int x1, int y1, int x2, int y2) {
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }
    public boolean validRecruitPath(int x1, int y1, int x2, int y2) {
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }

    public void updateHungry(){
        if(MAX_ATTACK>numAttacks){
            this.hungry = true;
        }else{
            this.hungry = false;
        }
    }

    public void speak(){
        System.out.println("Roar!");
    }
    public boolean validMovePath(int x1, int y1, int x2, int y2){
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }
    public PieceEvilMinion spawn(){
        return new PieceEvilMinion(super.getSymbol(),super.getTeamColor(),1,0,0,false,false);
    }
    public boolean validSpawnPath(int x1, int y1, int x2, int y2){
        if((x1 == x2) && (y1 != y2)){
            return true;
        }else{
            return false;
        }
    }
}
