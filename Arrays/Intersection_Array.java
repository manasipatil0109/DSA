/*
 * 349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */


package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection_Array {

    /*
     * Solution 1
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i:nums1)
            s1.add(i);
        for(int i:nums2)
            s2.add(i);
        int k=0;
        for(Integer num: s1){
            if(s2.contains(num)){
                nums1[k++]=num;
            }
        }
        return Arrays.copyOf(nums1,k);
    }


    /*
     * Solution 2- leetcode solution faster
     */

     public int[] intersection1(int[] nums1, int[] nums2) {
        boolean[] fq = new boolean[1001];

        for(int n : nums1) {
            fq[n] = true;;
        }

        List<Integer> list = new ArrayList<>();

        for(int n : nums2) {
            if(fq[n]) {
                list.add(n);
                fq[n] = false;
            }
        }

        int[] result = new int[list.size()];       

        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
