/*
 * 1544. Make The String Great

Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"
 */

package Strings;

public class Make_String_Great {

    /*
     * Solution 1
     */
    public String makeGood(String s) {
        for(int i=1;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            if(((c1>='A' && c1<='Z') 
            && (c2==Character.toLowerCase(c1)) 
            && (c2>='a' && c2<='z')) || ((c2>='A' && c2<='Z') 
            && (c1==Character.toLowerCase(c2)) 
            && (c1>='a' && c1<='z'))){
                s=s.substring(0,i-1) + s.substring(i + 1);
                i=0;
            }
        }
        return s;
    }

    /*
     * Solution 2
     */
    public String makeGood1(String s) {
        for(int i=1;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            if(Math.abs(c1-c2)==32){
                s=s.substring(0,i-1) + s.substring(i + 1);
                i=0;
            }
        }
        return s;
    }
    
}
