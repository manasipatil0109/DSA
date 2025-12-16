/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8 
*/



package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    private void dfs(int open, int close, StringBuilder sb, int n, List<String> result){

        if(open == n && close == n){
            result.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            dfs(open+1, close, sb, n, result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            dfs(open, close+1, sb, n, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, new StringBuilder(), n, result);
        return result;
    }
}
