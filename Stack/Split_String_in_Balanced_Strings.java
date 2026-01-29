/*
1221. Split a String in Balanced Strings

Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
 

Constraints:

2 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string. 
*/


package Stack;

import java.util.Stack;

public class Split_String_in_Balanced_Strings {
    /*
    Solution 1 
    */
    public int balancedStringSplit(String s) {
        int count = 0;
        int l = 0;
        int r = 0;
        for(int i = 0;i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr=='R')
                r++;
            else
                l++;
            if(l==r){
                count++;
                l=0;
                r=0;
            }
        }
        return count;
    }

    /*
    Solution 2 
    */
    public int balancedStringSplit1(String s) {
        int count = 0;

        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && st.peek()!=c){
                st.pop();
            }else{
                st.push(c);
            }

            if(st.isEmpty())
                count++;
        }
        return count;
    }
}
