/*
383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters. 
*/



package Strings;

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {
    /*
    Solution 1 
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for(char c:magazine.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        for(char c: ransomNote.toCharArray()){
            if(hm.containsKey(c) && hm.get(c)>0){
                hm.put(c, hm.get(c)-1);
            } else{
                return false;
            }
        }
        return true;
    }


    /*
    Solution 2 
    */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] ch = new int[26];
        for(char c: magazine.toCharArray()){
            ch[c-'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            if(ch[c-'a']>0){
                ch[c-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
