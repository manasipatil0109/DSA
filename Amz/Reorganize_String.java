/*
 * 767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */


package Amz;

public class Reorganize_String {

    /*
     * Solution 1
     */
    public String reorganizeString(String s) {

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++)
        {
            int ind = s.charAt(i)-97;
            arr[ind]+=1;
            if(arr[ind]>(s.length()+1)/2)
            {
                return "";
            }
        }
        char[] cArr = new char[s.length()];
        int max=0;
        int mInd=0;
        for(int i=0;i<26;i++){
            if(max<arr[i]){
                mInd=i;
                max=arr[i];
            }
        }
        int j=0;
        for(int i=max;i>0;i--)
        {
            cArr[j]=(char)('a'+mInd);
            j=j+2;
        }
        arr[mInd]=0;
        for(int i=0;i<26;i++)
        {
            while(arr[i]>0)
            {
                if(j>s.length()-1)
                    j=1;
                cArr[j]=(char)(i+'a');
                j=j+2;
                arr[i]=arr[i]-1;
            }
        }
        return new String(cArr);
    }
}
