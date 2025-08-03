/*
 * 118. Pascal's Triangle
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> L = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> subL = new ArrayList<>();

            for(int j=0;j<=i;j++){
                subL.add(1);
            }
            for(int j=1;j<i;j++){
                subL.set(j,L.get(i-1).get(j-1)+L.get(i-1).get(j));
            }
            L.add(subL);
        }
        return L;
    }
    
}
