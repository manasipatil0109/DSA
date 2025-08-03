/*
 * 119. Pascal's Triangle II
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 * 
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> L = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            List<Integer> result =new ArrayList<>();
            for(int j=0;j<=i;j++){
                result.add(1);
            }
            for(int j=1;j<i;j++){
                result.set(j,L.get(j-1)+L.get(j));
            }
            L=result;
        }
        return L;
    }
}
