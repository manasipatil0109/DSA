/*
 * 2357. Make Array Zero by Subtracting Equal Amounts

You are given a non-negative integer array nums. In one operation, you must:

Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
Subtract x from every positive element in nums.
Return the minimum number of operations to make every element in nums equal to 0.

 

Example 1:

Input: nums = [1,5,0,3,5]
Output: 3
Explanation:
In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
Example 2:

Input: nums = [0]
Output: 0
Explanation: Each element in nums is already 0 so no operations are needed.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

package Amz;

public class Array_Zer0_Subtracting_Equal_Amounts {
    /*
     * Solution 1
     */
    public int minimumOperations(int[] nums) {
        int count=0;
        int[] arr = new int[101];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        int val=0;
        for(int i=1;i<101 && count<nums.length;i++){
            if(arr[i]!=0 && i-val > 0){
                val+=(i-val);
                arr[i]=0;
                count++;
            }
        }
        return count;
    }

    /*
     * Solution 2 - Adding number to set then returning set size.
     */

}
