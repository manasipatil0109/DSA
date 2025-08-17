/*
 * 1047. Remove All Adjacent Duplicates In String
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 */

package Stack;

import java.util.Stack;

public class Remove_Adjacent_Duplicates_String {
    /*
     * Solution 1
     */
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(!st.empty() && st.peek()==c){
                st.pop();
            } else{
                st.push(c);
            }
        }
        s="";
        while(!st.empty())
            s+=st.pop();
        return new StringBuilder(s).reverse().toString();
    }
}
