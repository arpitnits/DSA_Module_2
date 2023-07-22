package Backtracking;

public class TowerOfHanoi {


    void towerOfHanoi(int n, char source, char destination, char spare) {

        if(n==1) {
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(n-1, source, spare, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1, spare, destination, source);
    }
    public void solveHanoi(int n) {
        char sourcePeg = 'A';
        char destinationPeg = 'C';
        char sparePeg = 'B';

        towerOfHanoi(n, sourcePeg, destinationPeg, sparePeg);
    }
}
