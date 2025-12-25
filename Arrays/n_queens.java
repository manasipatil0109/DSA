/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
 
*/


package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n_queens {
    /*
    Solution 1 
    */
    private boolean isValid(int row, int col, char[][] mat){
        int n = mat.length;
        int i,j;

        for(i=0;i<row;i++){
            if(mat[i][col]=='Q'){
                return false;
            }
        }
        
        for(i=row-1,j=col+1; i>=0 && j<n; i--, j++){
            if(mat[i][j]=='Q'){
                return false;
            }
        }

        for(i=row-1,j=col-1; i>=0 && j>=0; i--, j--){
            if(mat[i][j]=='Q'){
                return false;
            }
        }

        return true;        
    }


    private void queenPos(int row, List<List<String>> ans, char[][] mat){
        int n = mat.length;
        if(row == n){
            List<String> q = new ArrayList<>();
            for(int i=0;i<n;i++){
                q.add(new String(mat[i]));
            }
            ans.add(new ArrayList<>(q));
            return;
        }

        for(int i=0;i<n;i++){
            if(isValid(row, i, mat)){
                mat[row][i]='Q';
                queenPos(row+1, ans, mat);
                mat[row][i]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], '.');
        }
        queenPos(0, ans, mat);
        return ans;
    }
}
