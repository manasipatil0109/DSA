/*
 * 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */



package Arrays;

public class Search_Rotated_Array {

    /*
     * Solution 1
     */
    private int binaryS(int l, int r, int[] nums, int target){
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
    public int search1(int[] nums, int target) {
        int i;
        for(i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i])
                break;
        }
        int res = binaryS(0, i-1, nums, target);
        if(res==-1)
            res = binaryS(i, nums.length-1, nums, target);
        return res;
    }


    /*
     * Solution 2 - the time complexity at worst case is O(n)
     */
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target == nums[i])
                return i;
        }
        return -1;
    }
}
