/*
 * 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

package Arrays;

public class Position_Element_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid = (l+r)/2;
            if(nums[mid]==target)
                break;
            else if(nums[mid]<target)
                l=mid+1;
            else
                r=mid-1;
        }
        if(l>r)
            return result;
        l=mid;
        while(l>=0 && nums[l]==target)
            l--;
        result[0]=l+1;
        r=mid;
        while(r<nums.length && nums[r]==target)
            r++;
        result[1]=r-1;
        return result;
    }
}
