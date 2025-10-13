/*
 * 242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */


package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class Valid_Anagram {

    /*
     * Solution 3 - fastest solution
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] sa=s.toCharArray();
        Arrays.sort(sa);
        char[] ta=t.toCharArray();
        Arrays.sort(ta);
        s=new String(sa);
        t=new String(ta);
        return s.equals(t);
    }


    /*
     * Solution 1
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character, Integer> hm =new HashMap<>();
        for(char c:s.toCharArray())
            hm.put(c, hm.getOrDefault(c, 0)+1);
        for(char c:t.toCharArray()){
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)-1);
                if(hm.get(c)==0)
                    hm.remove(c);
            }else{
                return false;
            }
        }
        return true;
    }


    /*
     * Solution 2
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] ca= new int[26];
        for(int i=0;i<s.length();i++){
            ca[s.charAt(i) - 'a']++;
            ca[t.charAt(i) - 'a']--;
        }
        for(int i:ca){
            if(i!=0)
                return false;
        }
        return true;
    }
}
