/*
78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. 
*/


package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
    Solution 1 - 2 loops - iterative
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums){
            int size = result.size();
            for(int i=0;i<size;i++){
                List<Integer> s = new ArrayList<>(result.get(i));
                s.add(num);
                result.add(s);
            }
        }
        return result;
    }
}
