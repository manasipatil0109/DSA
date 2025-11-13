/*
 * Search Insert Position
 * 
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */


package Arrays;

public class Search_Insert_Position {

    /* 
    * Solution 1 
    */
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target)
            return 0;
        if(nums[nums.length-1]<target)
            return nums.length;
        if(nums[nums.length-1]==target)
            return nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==target)
                return i;
            if(nums[i]<target && nums[i+1]>target){
                return i+1;
            }
        }
        return 0;
    }

    /*
     * Solution 2
     */
    public int searchInsert2(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                r = mid-1;
            else
            l = mid+1;
        }
        return l;
    }

    // Solution 3
    public int searchInsert3(int[] nums, int target) {
        int l=0;
        int r= nums.length;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>= target)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
}
