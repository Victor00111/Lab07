public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int x);
    public abstract boolean validAttackPath(int x1, int y1, int x2, int y2);
}
