/*
 * 937. Reorder Data in Log Files

You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Constraints:

1 <= logs.length <= 100
3 <= logs[i].length <= 100
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */

package Amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Reorder_Data_LogFile {

    /*
     * Solution 1
     */
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            String[] pa = a.split("\\s+", 2);
            String[] pb = b.split("\\s+", 2);
            int cmp = pa[1].compareTo(pb[1]);     // compare content
            if (cmp == 0) return pa[0].compareTo(pb[0]); // tie → compare id
            return cmp;
        });
        ArrayList<String> arr = new ArrayList<>();
        for(String s:logs){
            String[] c = s.split("\\s+",2);
            if(c[1].charAt(0)>='0' && c[1].charAt(0)<='9')
                arr.add(s);
            else
                pq.add(s);
        }
        int i=0;
        while(!pq.isEmpty()){
            logs[i]=pq.poll();
            i++;
        }
        for(String s: arr){
            logs[i]=s;
            i++;
        }
        return logs;
    }


    /*
     * Solution 2
     */
    public String[] reorderLogFiles1(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String arr1[] = a.split(" ",2);
            String arr2[] = b.split(" ",2);

            String key1 = arr1[0];
            String val1 = arr1[1];
            String key2 = arr2[0];
            String val2 = arr2[1];

            boolean isDigit1 = Character.isDigit(val1.charAt(0));
            boolean isDigit2 = Character.isDigit(val2.charAt(0));

            if(!isDigit1 && !isDigit2){
                int com = val1.compareTo(val2);
                if(com!=0)
                return com;
                else{
                     return key1.compareTo(key2);
                }
            }
            if(isDigit1 && !isDigit2)
            return 1;
            else if(!isDigit1 && isDigit2)
            return -1;

            return 0;
        });

        return logs;
    }
}
