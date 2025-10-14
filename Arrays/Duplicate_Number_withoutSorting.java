/*
 * 287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */


package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Duplicate_Number_withoutSorting {
    /*
    * Solution 1
    */
    public int findDuplicate(int[] nums) {
        int[] s = new int[nums.length];
        for(int i:nums){
            if(s[i]!=0)
                return i;
            s[i]=s[i]+1;
        }
        return -1;
    }

    /*
    * Solution 2
    */
    public int findDuplicate1(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums){
            if(s.contains(i))
                return i;
            else
                s.add(i);
        }
        return -1;
    }
}
