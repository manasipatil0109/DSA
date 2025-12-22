/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters. 
*/



package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /*
    Solution 1 
    */
    private boolean isPalindrome(String s, int l, int r){
        if(l>r)
            return false;
        while(l<=r){
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if(cl !=cr)
                return false;
            l++;
            r--;
        }
        return true;
    }

    private void backtrac(int index, List<List<String>> result, List<String> subs, String s){
        if(index == s.length()){
            result.add(new ArrayList<>(subs));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                subs.add(s.substring(index,i+1));
                backtrac(i+1, result, subs,s);
                subs.remove(subs.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrac(0, result, new ArrayList<>(), s);
        return result;
    }
}
