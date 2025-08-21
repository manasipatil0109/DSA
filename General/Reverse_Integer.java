/*
 * 7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */

package General;

public class Reverse_Integer {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        String ans = sb.reverse().toString();
        if(ans.charAt(ans.length()-1)=='-'){
            ans="-"+ans.substring(0, ans.length()-1);
        }
        long val = Long.parseLong(ans);
        if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) val;
    }
}
