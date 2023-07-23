package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    int[] rowMove = {-1, 1, 0, 0};
    int[] colMove = {0, 0, 1, -1};

    char[] direction = {'U', 'D', 'R', 'L'};

    List<String> allPaths = new ArrayList<>();
    private boolean isSafe(int row, int col, int n, int[][] maze, int[][] visited) {
        if(row>=0 && row<n && col>=0 && col<n && maze[row][col]==1 && visited[row][col]==-1)
            return true;
        return false;
    }
    private void findAllPaths(int[][] maze, int[][] visited, int row, int col, int n, String path) {

        if(row==n-1 && col ==n-1){
            allPaths.add(path);
            return;
        }

        int next_row, next_col;
        for(int i=0;i<rowMove.length;i++) {
            next_row = row + rowMove[i];
            next_col = col + colMove[i];
            if(isSafe(next_row, next_col, n , maze, visited)) {
                visited[row][col] = 1;
                findAllPaths(maze, visited, next_row, next_col, n, path+direction[i]);
                visited[row][col] = -1;
            }

        }

    }

    public void ratMaze() {

        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 1}};

        int n = maze.length;

        int[][] visited = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j] = -1;
            }
        }

        findAllPaths(maze, visited, 0, 0, n, "");

        for(String path: allPaths) {
            System.out.println(path);
        }

    }
}
