package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())
            return false;
        int j=0;
        for(int i=0;i<t.length() && j<s.length();i++){
            while(i<t.length() && s.charAt(j)!=t.charAt(i)){
                i++;
            }
            if(i == t.length())
                return false;
            j++;
        }
        if(j == s.length())
            return true;
        else
            return false;
    }


    /*
    Solution for follow up question 
    */
    Map<Character, List<Integer>> map = new HashMap<>();

    public boolean isSubsequence1(String s, String t) {

        if (map.isEmpty()) {
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
            }
        }

        int prevIndex = -1;

        for (char c : s.toCharArray()) {

            // char does not exist in t
            if (!map.containsKey(c)) 
                return false;

            List<Integer> positions = map.get(c);

            // Use binary search to find smallest index > prevIndex
            int nextIndex = findNext(positions, prevIndex);

            if (nextIndex == -1)   
                return false;

            prevIndex = nextIndex;
        }

        return true;
    }

    // Binary search: first number > prevIndex
    private int findNext(List<Integer> arr, int prevIndex) {
        int left = 0, right = arr.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) > prevIndex) {
                result = arr.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}