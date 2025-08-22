/*
 * 709. To Lower Case

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.
 */


package Strings;

public class to_Lowercase {
    /*
     * Solution 1 
     */
    public String toLowerCase(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c>='A' && c<='Z'){
                sb.append((char)(c+32));
            }
            else
                sb.append(c);
        }
        return sb.toString();
    }

    /*
     * Solution 2
     */
    public String toLowerCase2(String s) {
        return s.toLowerCase();
    }
}
