/**
 * <h1>Lab 7 </h1>
 *
 * <h2>CISC 181-40L Spring 2022</h2>
 *
 * <h3>University of Delaware</h3>
 *
 * <p>
 * // Rules for the game and qualifications for actions
 *
 * @author Zachariah Barraza, Cam Kennedy, and Victor Tung
 *
 * @since (2022-05-05)
 */
public class Rules {

    public static boolean checkValidAction(GameS22 gameS22, int row1, int col1, int row2, int col2, char action) {
        // New Rule Modification -
        if (action == 'B' || action == 'b') {
            if (gameS22.getGameBoard().inBounds(row1, col1) && gameS22.getGameBoard().inBounds(row2, col2)) {
                if (!(gameS22.getGameBoard().getSquares()[row1][col1].isEmpty())) {
                    if (gameS22.turn.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor)) {
                        if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'N' || gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'B') {
                            if ((row2 - row1 <= 4 || row1 - row2 <= 4) && (col2 - col1 <= 4 || col1 - col2 <= 4)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        if (action == 'M' || action == 'm') {
            if (gameS22.getGameBoard().inBounds(row1, col1) && gameS22.getGameBoard().inBounds(row2, col2)) {
                if (!(gameS22.getGameBoard().getSquares()[row1][col1].isEmpty())) {
                    if (gameS22.getGameBoard().getSquares()[row2][col2].isEmpty()) {
                        if (gameS22.turn.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor)) {
                            if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().validMovePath(row1, col1, row2, col2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        if (action == 'S' || action == 's') {
            if (gameS22.getGameBoard().inBounds(row1, col1) && gameS22.getGameBoard().inBounds(row2, col2)) {
                if (!(gameS22.getGameBoard().getSquares()[row1][col1].isEmpty())) {
                    if (gameS22.getGameBoard().getSquares()[row2][col2].isEmpty()) {
                        if (gameS22.turn.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor)) {
                            if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().validMovePath(row1, col1, row2, col2)) {
                                if (!(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'B')) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (action == 'R' || action == 'r') {
            if (gameS22.getGameBoard().inBounds(row1, col1) && gameS22.getGameBoard().inBounds(row2, col2)) {
                if (!(gameS22.getGameBoard().getSquares()[row1][col1].isEmpty())) {
                    if (!(gameS22.getGameBoard().getSquares()[row2][col2].isEmpty())) {
                        if (!(gameS22.getGameBoard().getSquares()[row2][col2].getPiece().teamColor.equals(gameS22.getCurrentTeam().getTeamColor()))) {
                            if (gameS22.turn.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor)) {
                                if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().validMovePath(row1, col1, row2, col2)) {
                                    if (!(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'B')) {
                                        return true;
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

        if (action == 'A' || action == 'a') {
            if (gameS22.getGameBoard().inBounds(row1, col1) && gameS22.getGameBoard().inBounds(row2, col2)) {
                if (!(gameS22.getGameBoard().getSquares()[row1][col1].isEmpty())) {
                    if (!(gameS22.getGameBoard().getSquares()[row2][col2].isEmpty())) {
                        if (gameS22.turn.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor)) {
                            if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().validAttackPath(row1, col1, row2, col2)) {
                                if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().canAttack()) {
                                } if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'H' || gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'B' || gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'S' || gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 's' ) {
                                    if (!(gameS22.getGameBoard().getSquares()[row2][col2].getPiece().teamColor.equals(gameS22.getGameBoard().getSquares()[row1][col1].getPiece().teamColor))) {
                                        return true;
                                    }
                                } else if (gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'E' || gameS22.getGameBoard().getSquares()[row1][col1].getPiece().symbol == 'e') {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\n**************************************************************************\nThis is not a valid move.\n**************************************************************************\n ");
        System.out.println(gameS22.toString());
        return false;
    }
}
