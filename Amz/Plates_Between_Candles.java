/*
 * 2055. Plates Between Candles

There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.

You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.

For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
Return an integer array answer where answer[i] is the answer to the ith query.

 

Example 1:

ex-1
Input: s = "**|**|***|", queries = [[2,5],[5,9]]
Output: [2,3]
Explanation:
- queries[0] has two plates between candles.
- queries[1] has three plates between candles.
Example 2:

ex-2
Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
Output: [9,0,0,0,0]
Explanation:
- queries[0] has nine plates between candles.
- The other queries have zero plates between candles.
 

Constraints:

3 <= s.length <= 105
s consists of '*' and '|' characters.
1 <= queries.length <= 105
queries[i].length == 2
0 <= lefti <= righti < s.length
 */


package Amz;

public class Plates_Between_Candles {

    /*
     * Solution 1
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {

        int n = s.length();
        char[] ch = s.toCharArray();
        int[] res = new int[queries.length];
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '|') last = i;
            left[i] = last;
        }
        
        last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] == '|') last = i;
            right[i] = last;
        }

        int[] platesCount = new int[n];
        platesCount[0]=(ch[0]=='*'?1:0);
        for(int i=1;i<n;i++){
            platesCount[i]=platesCount[i-1]+(ch[i]=='*'?1:0);
        }
        
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0], r = queries[qi][1];
            
            int j = right[l];   
            int k = left[r];    
                        
            if (j != -1 && k != -1 && j < k) {
                res[qi]=platesCount[k]-platesCount[j];

            } else{
                res[qi]=0;
            }
            
        }
        
        return res;
    }


    /*
     * Solution 2 - but this shows time limit exceeded error
     */
    public int[] platesBetweenCandles1(String s, int[][] queries) {

        int[] arr = new int[queries.length];
        char[] ch = s.toCharArray();
        int count=0;
        for(int i=0;i<queries.length;i++)
        {
            int res=0;
            int start=0;
            int end=0;
            int j=(s.substring(queries[i][0],queries[i][1])+1).indexOf('|')+queries[i][0];
            int k = queries[i][0] + s.substring(queries[i][0], queries[i][1] + 1).lastIndexOf('|');
            while(j<=k)
            {
                System.out.println(j+" "+k);
                if(ch[j]=='|')
                {
                    if(start==0)
                        start=1;
                }
                if(ch[k]=='|')
                {
                    if(end==0)
                        end=1;
                }
                if(ch[j]=='*')
                {
                    if(start==1)
                        res++;
                    if(j==k)
                        break;
                }
                if(ch[k]=='*')
                {
                    if(end==1)
                        res++;
                }
                j++;k--;
            }
            if(start==0 || end==0){
                res=0;
                System.out.println(s.substring(queries[i][0],queries[i][1])+" "+start+" "+end);
            }
            arr[count++]=res;
        }
        return arr;
    }
}
