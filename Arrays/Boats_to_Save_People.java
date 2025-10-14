/*
 * 881. Boats to Save People

You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
 */



package Arrays;

import java.util.Arrays;

public class Boats_to_Save_People {
    /*
     * Solution 1
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count=0;
        for(int i=0,j=people.length-1;i<=j;){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            count++;
        }
        return count;
    }

    /*
     * Solution 2
     */
    public int numRescueBoats1(int[] people, int limit) {
        int[] weight = new int[limit+1];
        for(int i:people){
            weight[i]++;
        }

        int l=0,r=limit, count=0;
        while(l<=r){
            if(weight[l]<=0)
                l++;
            else if(weight[r]<=0)
                r--;
            else if(l+r<=limit){
                weight[l]--;
                weight[r]--;
                count++;
            }else{
                weight[r]--;
                count++;
            }
        }
        return count;
    }
}
