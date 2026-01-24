/*
 * 136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1

 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */


package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Single_Number {
    /*
     * Solution 1
     */
    public int singleNumber(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int i=1;
        while(i<nums.length){
            if(nums[i]==nums[i-1])
                i=i+2;
            else
                break;
        }
        return nums[i-1];
    }

    /*
     * Solution 2
     */
    public int singleNumber1(int[] nums) {
        int t=0;
        HashSet<Integer> h = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!h.contains(nums[i])){
                h.add(nums[i]);
                t+=nums[i];
            }
            else{
                t-=nums[i];
            }
        }
        return t;
    }


    /*
    Solution 3 - O(n) time and O(1) space 
    */
    public int singleNumber2(int[] nums) {

        int ans = 0;
        for(int i: nums){
            ans^=i;
        }
        return ans;
    }
}
