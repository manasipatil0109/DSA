/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/


package Strings;

public class Reverse_Words_in_String {

    /*
    Solution 1 
    */
    public String reverseWords(String s) {
        String[] sArr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = sArr.length-1;i>=0;i--){
            if(sArr[i]!=""){
                sb.append(sArr[i]);
                if(i>0)
                    sb.append(" ");
            }
        }

        return sb.toString();
    }

    /*
    Solution 2 - Follow up in place 
    */
   private void reverse(char[] c, int l, int r){
        while(l<r){
            char temp = c[l];
            c[l++]=c[r];
            c[r--]=temp;
        }
    }

    public String reverseWords1(String s) {

        //in place solution
        char[] ch = s.toCharArray();
        int n = ch.length, i=0, j=0; 
        while(i<n){
            while(i<n && ch[i]==' ') i++;
            while(i<n && ch[i]!=' ') ch[j++]=ch[i++];
            while(i<n && ch[i]==' ') i++;
            if(i<n) 
                ch[j++]=' ';
        }
        reverse(ch, 0, j-1);

        int start=0;
        i=0;
        while(i<j){
            while(i<j && ch[i]!=' ') i++;
            reverse(ch, start, i-1);
            start = i+1;
            i++;
        }
        return new String(ch, 0, j);
    }
}
