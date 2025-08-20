/*
 * 1748. Sum of Unique Elements

You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 
 */

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Sum_of_Unique_Elements {
    public int sumOfUnique(int[] nums) {
        int sum=0;
        Map<Integer,Integer> s = new HashMap<>();
        for(int i:nums){
            if(s.containsKey(i)){
                s.put(i,s.get(i)+1);
            } else{
                s.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> me: s.entrySet()){
            if(me.getValue()==1)
                sum+=me.getKey();
        }
        return sum;
    }
}
