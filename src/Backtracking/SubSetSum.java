package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    private void backTrackArrayForSubSetSum(int[] arr, int target, int currentIndex, List<Integer> subSet) {

        if(target==0) {
            System.out.println(subSet);
            return;
        }

        if(currentIndex==arr.length) {
            return;
        }

        //reject current element
        backTrackArrayForSubSetSum(arr, target, currentIndex+1, subSet);

        //select current element
        subSet.add(arr[currentIndex]);
        backTrackArrayForSubSetSum(arr, target-arr[currentIndex], currentIndex+1, subSet);
        subSet.remove(subSet.size()-1);
    }
    public void getSubSetSumEqualToTarget() {
        int[] arr = {2,3,2,4,2};
        int target = 4;

        List<Integer> subSet = new ArrayList<>();
        backTrackArrayForSubSetSum(arr, target, 0, subSet);

    }
}
