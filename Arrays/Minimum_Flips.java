/*
1318. Minimum Flips to Make a OR b Equal to c

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

 

Example 1:



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0
 

Constraints:

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9 
*/


package Arrays;

public class Minimum_Flips {
    /*
    Solution 1 - without bit operations
    */
    public int minFlips(int a, int b, int c) {
        int flip = 0;
        while(a!=0 || b!=0 || c!=0){
            int v1 = a%2;
            int v2 = b%2;
            int v3 = c%2;
            if(v3 == 0){
                if(v1!=0)
                    flip++;
                if(v2!=0)
                    flip++;
            }else{
                if(v1!=1 && v2!=1)
                    flip++;
            }
            a/=2;
            b/=2;
            c/=2;
        }

        return flip;
    }



    /*
    Solution 2 - using bitwise 
    */
    public int minFlips1(int a, int b, int c) {
        int flip = 0;
        while(a!=0 || b!=0 || c!=0){
            int v1 = a & 1; // modulo by 2
            int v2 = b & 1;
            int v3 = c & 1;
            if(v3 == 0){
                flip+=v1+v2;
            }else{
                if(v1!=1 && v2!=1)
                    flip++;
            }
            a>>=1; // divide by 2
            b>>=1;
            c>>=1;
        }

        return flip;
    }
}
