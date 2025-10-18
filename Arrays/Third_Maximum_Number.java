/*
 * 414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?
 */


package Arrays;

public class Third_Maximum_Number {

    /* 
     * Solution 1 - 0ms time only
     */
    public int thirdMax1(int[] nums) {
        long n1=Long.MIN_VALUE, n2=Long.MIN_VALUE, n3=Long.MIN_VALUE;
        for(int n:nums){
            long i=n;
            if(i>n1){
                n3=n2;
                n2=n1;
                n1=i;
            } else if(i>n2 && i!=n1){
                n3=n2;
                n2=i;
            }else if(i>n3 && i!=n1 && i!=n2){
                n3=i;
            }
        }
        if(n3==Long.MIN_VALUE)
            return (int)n1;
        else
            return (int)n3;
    }

    /*
     * Solution 2 
     */
    public int thirdMax(int[] nums) {
        Long n1=null, n2=null, n3=null;
        for(int n:nums){
            long i=n;
            if ((n1 != null && i == n1) || 
                (n2 != null && i == n2) || 
                (n3 != null && i == n3)) 
                    continue;

            if(n1==null || i>n1){
                n3=n2;
                n2=n1;
                n1=i;
            } else if(n2==null || i>n2){
                n3=n2;
                n2=i;
            }else if(n3==null || i>n3){
                n3=i;
            }
        }
        if(n3==null)
            return n1.intValue();
        else
            return n3.intValue();
    }
}
