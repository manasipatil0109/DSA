/*
 * 2000. Reverse Prefix of Word

Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.

 

Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
 
 */

package Stack;

import java.util.Stack;

public class Reverse_Prefix {

    /*
     * Solution 1
     */
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) 
            return word;
        
        char[] rString = word.substring(0,idx+1).toCharArray();
        for(int i=0,j=rString.length-1;i<j;i++,j--){
            char temp = rString[i];
            rString[i]=rString[j];
            rString[j]=temp;
        }
        return new String(rString) +word.substring(word.indexOf(ch)+1,word.length());
    }

    /*
     * Solution 2
     */
    public String reversePrefix1(String word, char ch) {
        if(word.indexOf(ch)==-1)
            return word;
        Stack<Character> st = new Stack<>();
        int i;
        for(i=0;i<word.length();i++){
            st.push(word.charAt(i));
            if(ch==word.charAt(i))
                break;
        }
        String result="";
        while(!st.empty()){
            result+=st.pop();
        }

        return result+word.substring(i+1, word.length());
    } 
}
