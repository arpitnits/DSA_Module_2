package Backtracking;

public class SudokuSolve {

    private boolean isSafe(char[][] board, int row, int col, int n, char value) {

        int sqrt = (int)Math.sqrt(n);
        int min_row = row - (row%sqrt), max_row = min_row + sqrt-1;
        int min_col = col - (col%sqrt), max_col = min_col + sqrt-1;

        //check for 3*3
        for(int i=min_row;i<=max_row; i++) {
            for(int j=min_col; j<=max_col;j++) {
                if(board[i][j] == value) {
                    return false;
                }
            }
        }

        //check for complete row
        for(int i=0;i<n;i++) {
            if(board[row][i]==value) {
                return false;
            }
        }

        //check for complete col
        for(int i=0;i<n;i++) {
            if(board[i][col]==value) {
                return false;
            }
        }

        return true;
    }
    private boolean backtrackSudoku(char[][] board, int n) {

        int row = -1, col =-1;
        boolean isEmpty = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='.') {
                    isEmpty = true;
                    row=i;
                    col=j;
                    break;
                }
            }
            if(isEmpty)
                break;
        }
        if(!isEmpty) {
            return true;
        }

        for(int value=1;value<=n;value++) {
            if(isSafe(board, row, col, n, (char)(value +'0'))) {
                board[row][col] = (char)(value +'0');
                if(backtrackSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        backtrackSudoku(board, 9);
    }
}
