package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    List<String> combination = new ArrayList<>();
    void backtrackParenthesis(String combo, int diff, int n) {


        if(combo.length()==2*n && diff==0) {
            combination.add(combo);
        }

        if(combo.length()==2*n || diff<0 || diff>n) {
            return;
        }

        backtrackParenthesis(combo + '(', diff +1 ,n);
        backtrackParenthesis(combo + ')', diff -1, n);
    }

    public void generateParenthesis(int n) {

        backtrackParenthesis("", 0, n);

        for(String combo: combination)
            System.out.println(combo);
    }
}
