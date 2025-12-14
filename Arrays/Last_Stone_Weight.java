/*
1046. Last Stone Weight

You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
Input: stones = [1]
Output: 1
 

Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000 
*/



package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Last_Stone_Weight {

    /*
    Solution 1 - priorityQueue 
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }



    /*
    Solution 2 - same time as sol 2
    */
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(y!=x)
                pq.add(x-y);
        }
        if(pq.isEmpty())
            return 0;
        else
            return pq.poll();
    }

    /*
    Solution 2 - not optimized 
    */
    public int lastStoneWeight1(int[] stones) {
        Arrays.sort(stones);
        int i = stones.length-1;
        while(i>0 && stones[i-1]!=0){
            if(stones[i]>stones[i-1]){
                stones[i-1]=stones[i]-stones[i-1];
            }else if(stones[i]==stones[i-1]){
                stones[i-1]=0;
            }else{
                stones[i-1]-=stones[i];
            }
            stones[i]=0;
            Arrays.sort(stones);
        }
        return stones[i];
    }
}
