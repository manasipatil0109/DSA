/*
5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 
Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters. 
*/


package Strings;

public class Longest_Palindromic_Substring {
    /*
    Solution 1 - TLE Brute force
    */
    private boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    public String longestPalindrome(String s) {
        String ans = "";
        for(int l = 0;l<s.length();l++){
            for(int r = l+1; r<=s.length(); r++){
                String curr = s.substring(l, r);
                if(ans.length()<curr.length() && isPalindrome(curr)){
                        ans = curr;
                }
            }
        }
        return ans;
    }

}
