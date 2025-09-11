/*
 * 228. Summary Ranges

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.
 */


package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        else if(nums.length==1)
            return new ArrayList<>(List.of(String.valueOf(nums[0])));
        List<String> result = new ArrayList<>();
        for(int i=0;i<nums.length;){
            String s = String.valueOf(nums[i]);
            int j=i+1;
            while(j<nums.length && nums[j]==nums[j-1]+1){
                j++;
            }
            if(i != j-1)
                s+="->"+nums[j-1];
            result.add(s);
            
            i=j;
        }
        return result;
    }
}
