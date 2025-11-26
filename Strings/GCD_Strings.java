/*
1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters. */


package Strings;

public class GCD_Strings {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        while(l2!=0){
            int t = l1%l2;
            l1 = l2;
            l2 = t;
        }
        String rep = str1.substring(0,l1);
        if (isRepeat(str1, rep) && isRepeat(str2, rep))
            return rep;
        
        return "";
    }

    private boolean isRepeat(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        if (n % m != 0) return false;
        
        for (int i = 0; i < n; i += m) {
            if (!s.substring(i, i + m).equals(p))
                return false;
        }
        return true;
    }
}
