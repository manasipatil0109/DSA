/*
 * 844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 * 
 */


package Strings;

import java.util.Stack;

public class Backspace_String_Compare {
    /*
     * Solution 1
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s_array = new Stack<>();
        Stack<Character> t_array = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!s_array.empty())
                    s_array.pop();
            }
            else
                s_array.push(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(!t_array.empty())
                    t_array.pop();
            }
            else
                t_array.push(t.charAt(i));
        }
        s="";
        t="";
        while(!s_array.empty())
            s+=s_array.pop();
        while(!t_array.empty())
            t+=t_array.pop();
        System.out.println(s+" - "+t);
        return s.equals(t);
    }

    /*
     * Solution 2
     */
}
