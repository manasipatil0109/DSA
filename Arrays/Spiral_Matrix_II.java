/*
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
*/

package Arrays;

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int val=1;
        int[][] result = new int[n][n];
        int t=0,b=n-1,l=0,r=n-1;
        while(t<=b && l<=r){
            for(int i=l;i<=r;i++){
                result[t][i]=val++;
            }
            t++;
            for(int i=t;i<=b;i++){
                result[i][r]=val++;
            }
            r--;
            if(t<=b){
                for(int i=r;i>=l;i--){
                    result[b][i]=val++;
                }
                b--;
            }
            if(l<=r){
                for(int i=b;i>=t;i--){
                    result[i][l]=val++;
                }
                l++;
            }
        }
        return result;
    }
}
