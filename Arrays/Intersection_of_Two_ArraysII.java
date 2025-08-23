/*
 * 350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Intersection_of_Two_ArraysII {

    /*
     * Solution 1
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> h1 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(h1.containsKey(nums1[i])){
                h1.put(nums1[i], h1.get(nums1[i])+1);
            }
            else{
                h1.put(nums1[i], 1);
            }
        }
        int k=0;
        for(int i=0;i<nums2.length;i++){
            if(h1.get(nums2[i])!=null && h1.get(nums2[i])>0){
                nums1[k++]=nums2[i];
                h1.put(nums2[i], h1.get(nums2[i])-1);
            }
        }
        return Arrays.copyOf(nums1,k);
    }

    /*
     * Solution 2 - optmized other's solution
     */
    public int[] intersect1(int[] nums1, int[] nums2) 
    {
        int n = nums1.length;
        int m = nums2.length;
        int a = Math.min(n, m);

        int[] count = new int[1001]; 
        int[] result = new int[a]; 

        for (int i = 0; i < n; i++) {
            count[nums1[i]]++;
        }

        int k = 0;
        for (int i = 0; i < m; i++) {
            if (count[nums2[i]] > 0) {
                result[k++] = nums2[i];
                count[nums2[i]]--;
            }
        }

        return java.util.Arrays.copyOfRange(result, 0, k);
    }
}
