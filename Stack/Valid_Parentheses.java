/*
 * 20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 * 
 */
package Stack;

import java.util.Stack;

public class Valid_Parentheses {

    /*
     * Solution 1
     */
    public boolean isValid1(String s) {
        if(s.length()%2!=0)
            return false;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='('||curr=='['||curr=='{')
                st.push(curr);
            else{
                if(st.empty())
                    return false;
                char prev = st.empty()?'a':st.peek();
                if((curr==')' && prev=='(')||(curr==']' && prev=='[')||(curr=='}' && prev=='{'))
                    st.pop();
                else
                    return false;
            }
        }
        return st.empty();
    }


    /*
     * Solution 2
     */
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = st.empty()?'a':st.peek();
            if((curr==')' && prev=='(')||(curr==']' && prev=='[')||(curr=='}' && prev=='{'))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        if(st.empty())
            return true;
        return false;
    }
}
