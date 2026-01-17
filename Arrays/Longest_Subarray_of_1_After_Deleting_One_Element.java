/*
1493. Longest Subarray of 1's After Deleting One Element

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. 
*/


package Arrays;

public class Longest_Subarray_of_1_After_Deleting_One_Element {
    /*
    Solution 1 
    */
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0;
        int max = 0;
        int zero = 0;

        while(r<nums.length){
            if(nums[r] == 0)
                zero++;

            while(zero>1){
                if(nums[l] == 0)
                    zero--;
                l++;
            }

            max = Math.max(max, r-l);
            r++;
        }
        return max;
    }
}
