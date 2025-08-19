/*
 * 258. Add Digits
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:

Input: num = 0
Output: 0
 */
package General;

public class Add_Digits {
    public int addDigits(int num) {
        if(num<10)
            return num;
        int val=0;
        while(num/10!=0){
            val+=num%10;
            num=num/10;
            if(num/10==0){
                if(val+(num%10)>9){
                    num=val+(num%10);
                    val=0;
                } else{
                    val+=num%10;
                }
            }
        }
        return val;
    }
}
