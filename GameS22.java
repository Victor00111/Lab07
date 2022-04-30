public class GameS22 extends Game{
    public GameS22(int rows, int cols, Team team1, Team team2){
        super(rows,cols,team1,team2);
    }
    @Override
    public boolean isAWinner() {
        if((team1.teamPieces.size() <= 0 && team2.teamPieces.size() > 0)||(team1.teamPieces.size() > 0 && team2.teamPieces.size() <= 0)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Team getWinner() {
        if(isGameEnded() == false){
            return null;
        }else{
            if(isAWinner() == true){
                if(team1.teamPieces.size() > 0){
                    return team1;
                }else{
                    return team2;
                }
            }else{
                return null;
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
