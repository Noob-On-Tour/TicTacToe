
package pkg;

class GetWinner {

    // create backend grid to check for a winner
    private char Board[][] = new char[6][7];
    private int checkWinner = 0;

    // sets a position on the grid by playerName value ("X" || "O")
    void setField(int btnNumber, String playerName) {
        int row = 0, col = 0;
        while (btnNumber > 6) {
            row++;
            btnNumber -= 7;
        }
        col = btnNumber;
        Board[row][col] = playerName.charAt(0);
    }

    private int checkRows(String playerName) {
        checkWinner = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (Board[i][j] == playerName.charAt(0)) {
                    checkWinner++;
                } else
                    checkWinner = 0;

                if (checkWinner == 3) {
                    return 1;
                }
            }
            checkWinner = 0;
        }
        return 0;
    }

    private int checkColumns(String playerName) {
        checkWinner = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (Board[j][i] == playerName.charAt(0)) {
                    checkWinner++;
                } else
                    checkWinner = 0;

                if (checkWinner == 3) {
                    return 1;
                }
            }
            checkWinner = 0;
        }
        return 0;
    }

    private int checkDiagonals(String playerName) {
        char Theplayer = playerName.charAt(0);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                // check diagonals starting from upper left
                if ((i + 2 < 6) && (j + 2 < 7)) {
                    if (Board[i][j] == Theplayer && Board[i + 1][j + 1] == Theplayer
                            && Board[i + 2][j + 2] == Theplayer) {
                        return 1;
                    }
                }
                // check diagonals starting from the upper right
                if ((i + 2 < 6) && (j - 2 > -1)) {
                    if (Board[i][j] == Theplayer && Board[i + 1][j - 1] == Theplayer
                            && Board[i + 2][j - 2] == Theplayer) {
                        return 1;
                    }
                }

            }
        }
        return 0;
    }

    // searches for any contigous 3 identical non-null char on the board
    int getWinner(String playerName) {

        // check row
        if (checkRows(playerName) == 1)
            return 1;

            // check column
        else if (checkColumns(playerName) == 1)
            return 1;

            // check diagonal starting from upper left
        else if (checkDiagonals(playerName) == 1)
            return 1;

        // All cases fail , no winner yet
        return 0;
    }

}
