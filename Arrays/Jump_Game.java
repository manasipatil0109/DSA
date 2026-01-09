/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105 
*/



package Arrays;

public class Jump_Game {
    /*
    Solution 1 
    */
   public boolean canJump(int[] nums) {
        int index = 0;
        int value = nums[0];
        int max=-1;
        int nextIndex = -1;
        if(value>=nums.length-1)
            return true;
        for(int i = 0;i<nums.length;){
            for(int j = index+1;j<=value+index && j<nums.length;j++){
                if(j+nums[j]>=max){
                    max=nums[j]+j;
                    nextIndex = j;  
                }
            }
            if(max >= nums.length-1 ){
                return true;
            }
            if(nextIndex <= index) {
                return false;
            }
            index = nextIndex;
            value = nums[index];
            max = -1;
            i = index;
        }
        return false;
    }

    /*
    Solution 2 
    */
    public boolean canJump1(int[] nums) {
        int goal = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(i+nums[i]>=goal)
                goal = i;
        }
        return goal==0;
    }

    /*
    Solution 3 
    */
    public boolean canJump2(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
