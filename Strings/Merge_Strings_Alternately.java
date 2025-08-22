/*
 * 1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
 */



package Strings;

public class Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i,j;
        for(i=0,j=0;i<word1.length() && j<word2.length();i++,j++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
        }
        if(i<word1.length()){
            sb.append(word1.substring(i, word1.length()));
        }
        if(j<word2.length()){
            sb.append(word2.substring(j, word2.length()));
        }
        return sb.toString();
    }
}
