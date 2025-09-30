/*
 * 1010. Pairs of Songs With Total Durations Divisible by 60

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500
 */



package Arrays;

public class Pairs_Divisible_by_60 {

    /*
     * Solution 1
     */
    public int numPairsDivisibleBy60(int[] time) {
        int result=0;
        int[] remain = new int[60];
        for(int i:time){
            int r = i%60;
            int c = (60-r)%60;
            result+=remain[c];
            remain[r]++;
        }
        return result;
    }


    /*
     * Brute force - but time limit exceed
     */
    public int numPairsDivisibleBy601(int[] time) {
        int result=0;
        for(int i=0;i<time.length-1;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i]+time[j])%60 == 0){
                    result++;
                }
            }
        }
        return result;
    }
}
