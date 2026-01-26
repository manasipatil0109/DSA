/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only. 
*/


package Strings;

import java.util.HashMap;

public class Longest_Palindrome {
    /*
    Solution 1 - 7ms 
    */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c:s.toCharArray())
            hm.put(c, hm.getOrDefault(c,0)+1);
        int length = 0;
        boolean odd = false;
        for(int i: hm.values()){
            if(!odd && i%2!=0){
                length+=1;
                odd = true;
            }
            i/=2;
            length+=i*2;
        }
        return length;
    }

    /*
    Solution 2 - faster 
    */
    public int longestPalindrome1(String s) {
        int[] count = new int[128];
        for(char c : s.toCharArray()) {
            count[c]++;
        }

        int longest = 0;
        boolean hasOdd = false;

        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 0) {
                longest += count[i];
            } else {
                longest += count[i] - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? longest + 1: longest;  
    }
}
