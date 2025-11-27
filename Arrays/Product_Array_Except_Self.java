/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.) 
*/

package Arrays;

public class Product_Array_Except_Self {
    /*
    Solution 1 
    */
   public int[] productExceptSelf(int[] nums) {
        int product =1;
        int count=0;
        for(int num:nums){
            if(num==0){
                count++;
            }else{
                product*=num;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= 0){
                if(count>0)
                    nums[i]=0;
                else
                    nums[i]=product/nums[i];
            } else{
                if(count>1)
                    nums[i]=0;
                else
                    nums[i]=product;
            }
        }
        return nums;
    }


    /*
    Solution 2 - Without division as per requirement
    */
   public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0]=1;
        for(int i=1;i<n;i++){
            result[i] = result[i-1]*nums[i-1];
        }

        int r = 1;
        for(int i=n-1;i>=0;i--){
            result[i] *= r;
            r *=nums[i]; 
        }

        return result;
    }
}
