/*
1657. Determine if Two Strings Are Close

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

 

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 

Constraints:

1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters. 
*/


package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class Determine_if_Two_Strings_Are_Close {

    /*
    Solution 1 - very slow approach though 
    */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char ch : word2.toCharArray()) {
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }

        if (!hm1.keySet().equals(hm2.keySet())) 
            return false;

        HashMap<Integer, Integer> freqCount1 = new HashMap<>();
        for (int freq : hm1.values()) {
            freqCount1.put(freq, freqCount1.getOrDefault(freq, 0) + 1);
        }

        HashMap<Integer, Integer> freqCount2 = new HashMap<>();
        for (int freq : hm2.values()) {
            freqCount2.put(freq, freqCount2.getOrDefault(freq, 0) + 1);
        }

        return freqCount1.equals(freqCount2);
    }

    /*
    Solution 2 - faster
    */
   public boolean closeStrings1(String word1, String word2) {

        int[] fw1 = new int[26];
        int[] fw2 = new int[26];

        for(char c:word1.toCharArray())
            fw1[c-'a']++;

        for(char c:word2.toCharArray())
            fw2[c-'a']++;
        
        for(int i=0;i<26;i++){
            if((fw1[i]>0) != (fw2[i]>0))
                return false;
        }

        Arrays.sort(fw1);
        Arrays.sort(fw2);
        return Arrays.equals(fw1,fw2);


        // // Alternative Solution
        // for(int i=0;i<26;i++){
        //     int w1 = fw1[i];
        //     if(w1>0){
        //         for(int j=0;j<26;j++){
        //             if(w1 == fw2[j]){
        //                 fw2[j]=0;
        //                 break;
        //             }
        //             if(j==25)
        //                 return false;
        //         }
        //     }
        // }
        // return true;
    }


}
