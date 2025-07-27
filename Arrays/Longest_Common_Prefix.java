/*
 * 14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

package Arrays;

class Longest_Common_Prefix {

    /*
    * Solution 1
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1)
            return strs[0];
        String temp = strs[0];
        String answer="";
        int i;
        for(int j=0;j<temp.length();j++){
            for(i=1;i<strs.length;i++){
                if(j<strs[i].length() && temp.charAt(j) == strs[i].charAt(j)){
                    continue;
                }
                else{
                    break;
                }
            }
            if(i==strs.length)
                answer+=temp.charAt(j);
            else
                break;
        }
        return answer;
    }
}



