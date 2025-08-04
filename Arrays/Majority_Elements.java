/*
 * 169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

 
package Arrays;

import java.util.HashMap;

public class Majority_Elements {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                hm.replace(i,hm.get(i)+1);
            } else{
                hm.put(i,1);
            }
            if(hm.get(i)>nums.length/2)
                return i;
        }
        return 0;
    }
}