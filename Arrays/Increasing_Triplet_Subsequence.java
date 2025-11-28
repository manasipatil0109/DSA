/*
Problem Statement
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that:

i < j < k, and
nums[i] < nums[j] < nums[k]
If no such indices exist, return false. 

Examples

Input: nums = [1, 2, 3, 4, 5] → Output: true (e.g. subsequence 1,2,3) 

Input: nums = [5, 4, 3, 2, 1] → Output: false 

Input: nums = [2, 1, 5, 0, 4, 6] → Output: true (e.g. subsequence 0,4,6 — indices 3, 4, 5) 

Constraints

1 <= nums.length <= 5 * 10^5 

Each nums[i] is a 32‑bit signed integer (e.g. within typical int range) 

Follow-up / Requirement: Try to implement a solution that runs in O(n) time and O(1) space.
*/


package Arrays;

public class Increasing_Triplet_Subsequence {
    /*
    Solution 1 - similar to 3rd largest
    */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=first){
                first = num;
            }else if(num<=second){
                second = num;
            }else{
                return true;
            }
        }
        return false;
    }
}
