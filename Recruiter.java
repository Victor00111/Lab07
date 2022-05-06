/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Interface for recruiting
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int x);
    public abstract boolean validRecruitPath(int x1, int y1, int x2, int y2);
}
