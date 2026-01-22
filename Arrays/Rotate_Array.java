/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space? 
*/




package Arrays;

public class Rotate_Array {
    /*
    Solution 1 - using extra memory 
    */
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int j = 0;
        k = k%nums.length;
        for(int i = nums.length-k;i<nums.length;i++){
            ans[j++] = nums[i];
        }
        for(int i = 0;i <nums.length-k; i++){
            ans[j++] = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = ans[i];
        }
    }


    /*
    Solution 2 - using single array and reverse 
    */
    private void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}
