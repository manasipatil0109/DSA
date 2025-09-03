/*
 * 859. Buddy Strings

Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 

Example 1:
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.

Example 3:
Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 

Constraints:
1 <= s.length, goal.length <= 2 * 104
s and goal consist of lowercase letters.
 */


package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Buddy_Strings {

    /*
     * Solution 1
     */
    public boolean buddyStrings(String s, String goal) {
        if(s.length()==1 || s.length()!=goal.length())
            return false;
        HashMap<Character, Character> m = new HashMap<>();
        Set<Character> sc = new HashSet<>();
        int sameC=0;
        int flag=0;
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2 = goal.charAt(i);
            if(c1!=c2){
                if(flag==0){
                    m.put(c1,c2);
                    flag++;
                } else if(flag==1){
                    if(!m.containsKey(c2) || m.get(c2)!=c1){
                        return false;
                    }
                    flag++;
                }else{
                    return false;
                }
            }
            if(sc.contains(c1))
                sameC=1;
            else
                sc.add(c1);        
        }
        if(s.equals(goal))
            return sameC==1;
        return flag==2;
    }

    /*
     * Solution 2 - faster solution
     */
    public boolean buddyStrings1(String s, String goal) {
        if(s.length()==1 || s.length()!=goal.length())
            return false;

        char[] sa=s.toCharArray();
        char[] ga=goal.toCharArray();
        if(s.equals(goal)){
            int[] ca=new int[26];
            for(char c:sa){
                ca[c-'a']++;
                if(ca[c-'a']>1)
                    return true;
            }
            return false;
        }

        int f1=-1;
        int f2=-1;
        int count=0;
        for(int i=0;i<sa.length;i++){
            if(sa[i]!=ga[i]){
                count++;
                if(f1==-1)
                    f1=i;
                else if(f2==-1)
                    f2=i;
                else
                    return false;
            }
        }

        return count==2 && sa[f1]==ga[f2] && sa[f2]==ga[f1];
    }
}
