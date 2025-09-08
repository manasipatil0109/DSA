/*
 * 387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */


package Strings;

import java.util.HashSet;
import java.util.Set;

public class First_Unique_Char {

    /*
     * Solution 1
     */
    public int firstUniqChar(String s) {
        Set<Character> sc = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!sc.contains(c) && s.substring(i+1, s.length()).indexOf(c)==-1)
                return i;
            sc.add(c);
        }
        return -1;
    }

    /*
     * Solution 2
     */
    public int firstUniqChar1(String s) {
        int[] ca = new int[26];
        for(char c:s.toCharArray()){
            ca[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(ca[c-'a']==1)
                return i;
        }
        return -1;
    }
}
