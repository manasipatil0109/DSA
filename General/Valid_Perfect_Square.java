/*
 * 367. Valid Perfect Square

Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 

Constraints:

1 <= num <= 231 - 1
 */

package General;

public class Valid_Perfect_Square {

    /*
     * solution 1 - O(log n)
     */
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        int l=1;
        int r=num/2;
        while(l<=r){
            int mid=l+(r-l)/2;
            long val=(long)mid*mid;
            if(val==num)
                return true;
            else if(val<num)
                l=mid+1;
            else 
                r=mid-1;
        }
        return false;
    }

    /*
     * Solution 2 - O(root n)
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 
        Not my code:
        
        int odd = 1;
        while (num > 0) {
            num -= odd;
            odd += 2;
        }
        return num == 0;
     */
}
