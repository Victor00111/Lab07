/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // The interface for attacker feature
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int x);
    public abstract boolean validAttackPath(int x1, int y1, int x2, int y2);
}
