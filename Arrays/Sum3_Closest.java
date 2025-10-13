/*
 * 16. 3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 */


package Arrays;

import java.util.Arrays;

public class Sum3_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int closest=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1, k=nums.length-1;j<k;){
                int val = nums[i]+nums[j]+nums[k];
                if(Math.abs(val-target) <= Math.abs(closest-target)){
                    closest=val;
                }
                if(val<target){
                    j++;
                }else if(val>target){
                    k--;
                }else{
                    return val;
                }
            }
        }
        return closest;
    }
}
