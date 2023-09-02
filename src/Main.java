import Array.ArrayModule;
import Array.Sorting;
import Backtracking.*;

import java.util.Scanner;

public class Main {

    public static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {


        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        //int d = sc.nextInt();
        long startTime = System.currentTimeMillis();
        Sorting sorting = new Sorting();
        sorting.quickSort(arr);
        //ArrayModule arrayModule = new ArrayModule();
        //System.out.println(arrayModule.trappingRainWater_Approach3(arr));
        printArray(arr);*/



        //System.out.println("Time took -> " + (System.currentTimeMillis()-startTime) +" ms");

        SudokuSolve sudokuSolve = new SudokuSolve();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        sudokuSolve.solveSudoku(board);

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}