/*
 * 342. Power of Four

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 */

package General;

public class Power_of_Four {

    /*
     * Solution 1
     */
    public boolean isPowerOfFour(int n) {
        if(n<1)
            return false;
        while(n%4==0)
            n/=4;
        return n==1;
    }

    /*
     * Solution 2 - using log without loop
     */
    public boolean isPowerOfFour1(int n) {
        if (n <= 0) return false;
        double logVal = Math.log(n) / Math.log(4);
        return logVal == (int) logVal;
    }


}
