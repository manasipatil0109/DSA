/*
 * 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */


package Arrays;

import java.util.Arrays;

public class Merge_Intervals {
    /*
     * Solution 1
     */
    public int[][] merge(int[][] interval) {
        Arrays.sort(interval, (a,b)->Integer.compare(a[0], b[0]));
        int[][] result = new int[interval.length][2];
        result[0][0]=interval[0][0];
        result[0][1]=interval[0][1];
        int j=0;
        for(int i=1;i<interval.length;i++){
            if(interval[i][0]<=result[j][1]){
                result[j][1]=Math.max(result[j][1], interval[i][1]);
            }else{
                j++;
                result[j][0]=interval[i][0];
                result[j][1]=interval[i][1];
            }
        }
        return Arrays.copyOf(result, j+1);
    }
}
