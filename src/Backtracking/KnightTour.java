package Backtracking;

public class KnightTour {

    int[] xMoves = {2, 2, -2, -2, 1, -1, 1, -1};
    int[] yMoves = {1, -1, 1, -1, 2, 2, -2, -2};


    boolean isSafe(int x, int y, int n, int[][] board) {
        if(x>=0 && x<n && y>=0 && y<n && board[x][y] == -1) {
            return true;
        }
        return false;
    }
    boolean traverse(int x, int y, int move, int n, int[][] board) {

        if(move==n*n) {
            return true;
        }
        int next_x, next_y;
        for(int i=0;i<8;i++) {
            next_x = x+xMoves[i];
            next_y = y+yMoves[i];
            if(isSafe(next_x, next_y, n, board)) {
                board[next_x][next_y] = move;
                if(traverse(next_x, next_y, move+1, n, board)) {
                    return true;
                } else {
                    board[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public void knightTour(int n) {

        int[][] board = new int[n][n];

        markNotVisited(board, n, n);
        int move =0;
        board[0][0] = move;
        if(!traverse(0, 0, move+1, n, board))  {
            System.out.println("solution not exist");
        } else {
            printBoard(board, n, n);
        }
    }

    void printBoard(int[][] board, int n ,int m) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    void markNotVisited(int[][] arr, int n, int m) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                arr[i][j] = -1;
            }
        }
    }
}
