import Array.ArrayModule;
import Array.Sorting;
import Backtracking.FindBinary;
import Backtracking.KnightTour;
import Backtracking.Parenthesis;
import Backtracking.TowerOfHanoi;

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

        Parenthesis parenthesis = new Parenthesis();
        parenthesis.generateParenthesis(3);
    }
}