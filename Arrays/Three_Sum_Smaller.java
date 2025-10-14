/*
 * 259. 3Sum Smaller

You are given an array of n integers called nums and an integer target. Your task is to find the number of index triplets (i, j, k) that satisfy the following conditions:

The indices must follow the order: 0 <= i < j < k < n
The sum of the three elements at these indices must be less than the target: nums[i] + nums[j] + nums[k] < target
For example, if nums = [-2, 0, 1, 3] and target = 2, you would need to find all combinations of three different indices where the sum of the corresponding elements is less than 2.

The key insight is that since we only care about the count of valid triplets and not their actual values or original positions, we can sort the array first. After sorting, we can efficiently use a two-pointer technique:

Fix the first element nums[i] by iterating through the array
For each fixed i, use two pointers j and k where j starts right after i and k starts at the end of the array
When nums[i] + nums[j] + nums[k] < target, all elements between j and k would also form valid triplets with i and j (since the array is sorted). This gives us k - j valid triplets at once
Move the pointers accordingly: increment j when the sum is less than target, decrement k when the sum is greater than or equal to target
This approach reduces the time complexity from O(n³) for a brute force solution to O(n²) by cleverly counting multiple valid triplets at once.

Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
 */


package Arrays;

import java.util.Arrays;

public class Three_Sum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int total = nums[i]+nums[j]+nums[k];
                if(total<target){
                    count+=k-j;
                    j++;
                }else{
                    k--;
                }
            }
        }
        return count;
    }
}
