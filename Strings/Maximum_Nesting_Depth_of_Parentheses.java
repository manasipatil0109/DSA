/*
 * 1614. Maximum Nesting Depth of the Parentheses

Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3
 */

package Strings;

public class Maximum_Nesting_Depth_of_Parentheses {
    public int maxDepth(String s) {
        int maxCount=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            } else if(s.charAt(i)==')'){
                count--;;
            }
            if(maxCount<count)
                maxCount=count;
        }
        return maxCount;
    }
}
