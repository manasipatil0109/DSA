/*
459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters. 
*/




package Strings;

public class Repeated_Substring_Pattern {
    /*
    Solution 1 
    */
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length()/2; i++){
            sb.append(s.charAt(i));
            String sub = sb.toString();

            if(s.length()%sub.length() != 0) 
                continue;

            int j = sub.length();
            boolean ok = true;
            
            while(j<s.length()){
                if(!s.startsWith(sub, j)){
                    ok=false;
                    break;
                }
                j+=sub.length();
            }
            if(ok)
                return true;
        }
        return false;
    }


    /*
    Solution 2 
    */
    public boolean repeatedSubstringPattern1(String s) {
        String snew = s+s;
        snew = snew.substring(1,snew.length()-1);
        return snew.indexOf(s)>=0?true:false;
    }
}
