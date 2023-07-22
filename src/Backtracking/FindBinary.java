package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindBinary {


    void backtrack(int n, String current, List<String> result) {

        if(current.length() == n) {
            result.add(current);
            return;
        }

        backtrack(n, current + "0" , result);
        backtrack(n, current + "1", result);

    }
    public void getBinaryOfLengthN(int n) {

        List<String> result = new ArrayList<>();

        backtrack(n, "", result);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
