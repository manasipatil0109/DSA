/*
 * 345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"


 */


package Strings;

import java.util.Arrays;
import java.util.List;

public class Reverse_Vowels_of_String {

    /*
    Solution 1 - faster
    */
   public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] ch = s.toCharArray();
        for(int i=0,j=ch.length-1;i<j;){
            while(i<j && !vowels.contains(ch[i])){
                i++;
            }
            while(i<j && !vowels.contains(ch[j])){
                j--;
            }
            char temp = ch[j];
            ch[j--]=ch[i];
            ch[i++]=temp;

        }
        return new String(ch);
    }

    /*
    Solution 2 
    */
    public String reverseVowels1(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] ch = s.toCharArray();
        for(int i=0,j=ch.length-1;i<j;){
            if(!vowels.contains(ch[i])){
                i++;
            }
            if(!vowels.contains(ch[j])){
                j--;
            }
            if(i>=j){
                continue;
            }
            if(vowels.contains(ch[i]) && vowels.contains(ch[j])){
                char temp = ch[j];
                ch[j--]=ch[i];
                ch[i++]=temp;
                
            }

        }
        return new String(ch);
    }
}
