/*
 * 857 · Minimum Window Subsequence

Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the smallest starting index.


All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
Example
Example 1:

Input：S="jmeqksfrsdcmsiwvaovztaqenprpvnbstl"，T="u"
Output：""
Explanation： unable to match
Example 2:

Input：S = "abcdebdde"， T = "bde"
Output："bcde"
Explanation："bcde" is the answer and "deb" is not a smaller window because the elements of T in the window must occur in order.

 */



package Strings;

public class Minimum_Window_Subsequence {
    public static String minWindow(String s, String t) {
        // Write your code here
        int sIdx =0;
        int m = s.length(), n = t.length();
        int minLength=Integer.MAX_VALUE;
        int startF=0;
        while(sIdx<m){
            int tIdx =0;
            int start =0;
            while(sIdx<m){
                if(t.charAt(tIdx) == s.charAt(sIdx)){
                    if(tIdx == 0)
                        start = sIdx;
                    tIdx++;
                }
                if(tIdx == n)
                    break;
                sIdx++;
            }
            if(tIdx < n)
                break;
            
            tIdx--;
            int end = sIdx;

            if(minLength> (end-start +1)){
                minLength = end-start +1;
                startF = start;
            }
            sIdx = start+1;
        }

        if(minLength == Integer.MAX_VALUE)
            return "";
        return s.substring(startF, startF+minLength);
    }

    public static void main(String[] args){
        System.out.println(minWindow("xxxxxxxxxabcdexxxde", "de"));
    }
}
