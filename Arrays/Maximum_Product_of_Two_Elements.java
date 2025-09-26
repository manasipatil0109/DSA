package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Product_of_Two_Elements{

    /* 
     * Solution 1
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        return (nums[n]-1)*(nums[n-1]-1);
    }

    /*
     * Solution 2
     */
    public int maxProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int n : nums){
            if(n > max1){
                max2 = max1;
                max1 = n;
            } else if (n > max2){
                max2 = n;
            }
        }
        return (max1-1) * (max2-1);
    }

    /*
     * Solution 3 - PriorityQueue
     */
    public int maxProduct3(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:nums){
            pq.add(i);
        }
        return (pq.poll()-1)*(pq.poll()-1);
    }
}