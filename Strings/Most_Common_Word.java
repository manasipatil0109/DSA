/*
 * 819. Most Common Word

Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Note that words can not contain punctuation symbols.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
 * 
 */



package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Most_Common_Word {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace(",", " ")
                            .replace(".", " ")
                            .replace("\"", " ")
                            .replace("!", " ")
                            .replace("?", " ")
                            .replace(";", " ")
                            .replace("'", " ")
                            .toLowerCase();
        String[] arr = paragraph.split("\\s+");
        HashMap<String, Integer> p = new HashMap<>();
        Set<String> b =new HashSet<>();
        for(String i:banned){
            b.add(i);
        }
        for(String i:arr){
            if(!b.contains(i)){
                if(p.containsKey(i)){
                    p.put(i,p.get(i)+1);
                }else{
                    p.put(i,1);
                }
            }
        }
        String max="";
        int val=0;
        for(Map.Entry<String, Integer> mp:p.entrySet()){
            if(val<mp.getValue())
            {
                val=mp.getValue();
                max=mp.getKey();
            }
        }
        return max;
    }
}