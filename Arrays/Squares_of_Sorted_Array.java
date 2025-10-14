/*
 * 977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */


package Arrays;

import java.util.Arrays;

public class Squares_of_Sorted_Array {
    /*
     * Brute force - trivial step
     */
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    /*
     * Follow up question
     */
    public int[] sortedSquares1(int[] nums) {
        int[] ans = new int[nums.length];
        int l=0, r=nums.length-1, k=nums.length-1;
        while(l<r){
            int n1= nums[l]*nums[l];
            int n2= nums[r]*nums[r];
            if(n1>n2){
                ans[k--]=n1;
                l++;
            }else if(n2>n1){
                ans[k--]=n2;
                r--;
            }else{
                ans[k--]=n1;
                ans[k--]=n2;
                l++;
                r--;
            }
        }
        if(k==0){
            ans[k--]=nums[l]*nums[l];
        }
        return ans;
    }
}
