/*
 * 2231. Largest Number After Digit Swaps by Parity

You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).

Return the largest possible value of num after any number of swaps.

 

Example 1:

Input: num = 1234
Output: 3412
Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
Swap the digit 2 with the digit 4, this results in the number 3412.
Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.
Example 2:

Input: num = 65875
Output: 87655
Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
Swap the first digit 5 with the digit 7, this results in the number 87655.
Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.
 

Constraints:

1 <= num <= 109
 */


package PriorityQueue;

import java.util.PriorityQueue;

public class Digit_swap {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        int temp = num;
        while(num!=0){
            int d = num%10;
            if(d%2==0)
                even.add(d);
            else
                odd.add(d);
            num=num/10;
        }
        StringBuilder sb = new StringBuilder();
        while(temp!=0){
            int d = temp%10;
            if(d%2==0){
                sb.insert(0,even.poll());
            }else{
                sb.insert(0,odd.poll());
            }
            temp=temp/10;
        }
        return Integer.parseInt(sb.toString());

    }
}
