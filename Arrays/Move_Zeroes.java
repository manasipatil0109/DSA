/*
 * 283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */

package Arrays;

public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=1;j<nums.length;){
            if(nums[i]!=0){
                i++;
                if(i>j)
                    j=i;
            }
            else if(nums[j]==0){
                j++;
            }
            else{
                nums[i++]=nums[j];
                nums[j++]=0;
            }
        }
    }

    /*
    Solution 2 
    */
   public void moveZeroes1(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j)
                    nums[i]=0;
                j++;
            }
        }
    }
}
