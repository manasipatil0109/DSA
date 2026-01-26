/*
448. Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space. 
*/


package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_All_Numbers_Disappeared_in_an_Array {
    /*
    Solution 1 
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i:nums){
            s.add(i);
        }

        for(int i = 1; i<nums.length+1; i++){
            if(!s.contains(i))
                ans.add(i);
        }
        return ans;
    }

    /*
    Solution 2 - faster
    */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] arr = new boolean[nums.length+1];
        for(int i:nums){
            arr[i]=true;
        }

        for(int i = 1;i<arr.length; i++){
            if(!arr[i])
                ans.add(i);
        }
        return ans;
    }


    /*
    Solution 3 - faster 
    */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int id = nums[i];
            if(id<0){
                id *= -1;
            }
            
            int index = id-1;
            if(nums[index]>0)
                nums[index] *= -1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                ans.add(i+1);
        }
        return ans;
    }
}
