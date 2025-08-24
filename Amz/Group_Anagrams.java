/*
 * 49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.


Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
 */


package Amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> hm = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s= new String(c);
            if(hm.containsKey(s)){
                hm.get(s).add(strs[i]);
            } else{
                List<String> lt = new ArrayList<>();
                lt.add(strs[i]);
                hm.put(s, lt);
            }
        }

        for(Map.Entry<String, List<String>> me: hm.entrySet()){
            result.add(me.getValue());
        }
        return result;
    }
}