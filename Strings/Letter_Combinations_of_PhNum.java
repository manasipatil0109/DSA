/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']. 
*/

package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_PhNum {
    /*
    Solution 1 
    */
    private void dfs(int index, String digit, StringBuilder sb, List<String> result, HashMap<Character, String> hm){
        if(index == digit.length()){
            result.add(sb.toString());
            return;
        }
        // if using string arr
        // int number = digit.charAt(index) - '0';
        // String charac = s[number];

        String charac = hm.get(digit.charAt(index));
        for(char c:charac.toCharArray()){
            sb.append(c);
            dfs(index+1,digit, sb, result, hm);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0)
            return result;
        HashMap<Character, String> hm = new HashMap<>(); 
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        //instead of hashmap string can also be use
        // String s[] = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        dfs(0,digits, new StringBuilder(), result, hm);
        return result;
    }
}
