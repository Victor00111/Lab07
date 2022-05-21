/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Winner qualifications for Game
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class GameS22 extends Game{
    public GameS22(int rows, int cols, Team team1, Team team2){
        super(rows,cols,team1,team2);
    }
    @Override
    public boolean isAWinner() {
        int tKing1 = 0;
        int tKing2 = 0;
        boolean standardWin;
        boolean kingWin;
        if((team1.teamPieces.size() <= 0 && team2.teamPieces.size() > 0)||(team1.teamPieces.size() > 0 && team2.teamPieces.size() <= 0)){
            standardWin = true;
        }else{
            standardWin = false;
        }

        for(int i = 0; i < team1.teamPieces.size();i++){
            if(team1.getTeamPieces().get(i).isKing() == true){
                tKing1 += 1;
            }
        }
        for(int i = 0; i < team2.teamPieces.size();i++){
            if(team2.getTeamPieces().get(i).isKing() == true){
                tKing2 += 1;
            }
        }
        if(tKing1 == 0 || tKing2 == 0){
            kingWin = true;
        }else{
            kingWin = false;
        }
        if(kingWin == true || standardWin == true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Team getWinner() {
        if(isAWinner() == false){
            return null;
        }
        else {
            boolean team1Win = false;
            for(int i = 0; i < team1.teamPieces.size();i++){
                if(team1.getTeamPieces().get(i).isKing() == true){
                    team1Win = true;
                }
                else {
                    team1Win = false;
                }
            }
            if(isAWinner() == true){
                if(team1.teamPieces.size() > 0){
                    return team1;
                }
                else{
                    return team2;
                }
            }
            else{
                if (team1Win) {
                    return team1;
                }
                else {
                    return team2;
                }
            }
        }
    }

    @Override
    public boolean isGameEnded() {
        if(team1.teamPieces.size() <= 0 || team2.teamPieces.size() <= 0){
            return true;
        }else{
            return false;
        }
    }
}
