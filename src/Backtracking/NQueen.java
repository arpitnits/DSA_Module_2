package Backtracking;

public class NQueen {


    private boolean isSafe(int row, int col, char[][] board, int n) {

        int dupCol, dupRow;

        //left side row
        dupCol=col;
        while(dupCol>=0) {
            if(board[row][dupCol]=='Q')
                return false;
            dupCol--;
        }

        //upper Diagonal
        dupCol=col;
        dupRow=row;
        while(dupCol>=0 && dupRow>=0) {
            if(board[dupRow][dupCol]=='Q')
                return false;
            dupCol--;
            dupRow--;
        }

        //lower Diagonal
        dupCol=col;
        dupRow=row;
        while(dupCol>=0 && dupRow<n) {
            if(board[dupRow][dupCol]=='Q')
                return false;
            dupCol--;
            dupRow++;
        }

        return true;
    }

    private void checkAllPaths(int col, char[][] board, int n) {
        if(col==n) {
            printBoard(board, n);
            return;
        }
        for(int row=0;row<n;row++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                checkAllPaths(col+1, board, n);
                board[row][col] = '.';
            }
        }
    }
    public void solveNQueen(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        checkAllPaths(0, board, n);
    }

    private void printBoard(char[][] board, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

}
