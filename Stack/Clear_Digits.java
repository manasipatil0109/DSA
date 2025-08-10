/*
 * 3174. Clear Digits
You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.

 

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

 

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.
 */

package Stack;

import java.util.Stack;

public class Clear_Digits {

    /*
     * Solution 1
     */
    public String clearDigits(String s) {
        char[] ch = s.toCharArray();
        int lc=-1;
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0' && ch[i]<='9'){
                ch[i]=' ';
                if(lc!=-1){
                    ch[lc]=' ';
                }
                i=-1;
                s=new String(ch);
                lc=-1;
                s = s.replace(" ", "");
                ch = s.toCharArray();
            }
            else{
                lc=i;
            }
        }
        s=new String(ch);
        s = s.replace(" ", "");
        return s;
    }

    /*
     * Solution 2
     */
    public String clearDigits1(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c:ch){
            if((c>='0' && c<='9') && !st.empty()){
                st.pop();
            } else{
                st.push(c);
            }
        }
        s="";
        while(!st.empty())
            s+=st.pop();
        ch = s.toCharArray();
        int left = 0, right = ch.length - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left++] = ch[right];
            ch[right--] = temp;
        }
        return new String(ch);
    }

}
