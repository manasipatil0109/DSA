/*
 * 347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */


package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    /*
     * Solution 1 - takes lot of time
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm =new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            int max=Integer.MIN_VALUE;
            for(Map.Entry<Integer, Integer> em :hm.entrySet()){
                if(max<em.getValue()){
                    result[i]=em.getKey();
                    max=em.getValue();
                }
            }
            hm.remove(result[i]);
        }
        return result;
    }

    /*
     * Solution 2- using priority queue
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> hm =new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
            new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> em :hm.entrySet()){
            pq.add(em);
            if(pq.size()>k)
                pq.poll();
        }

        int[] result = new int[k];

        for(int i=k-1;i>=0;i--){
            result[i]=pq.poll().getKey();
        }
        return result;
    }
}
