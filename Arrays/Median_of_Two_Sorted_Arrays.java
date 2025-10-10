/*
 * 4. Median of Two Sorted Arrays
Hard
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */



package Arrays;

public class Median_of_Two_Sorted_Arrays {
    /*
     * Solution 1 - O(m+n)
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] totalArr = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                totalArr[k++]=nums1[i++];
            } else if(nums1[i]>nums2[j]){
                totalArr[k++]=nums2[j++];
            } else{
                totalArr[k++]=nums1[i++];
                totalArr[k++]=nums2[j++];
            }
        }
        while(i<nums1.length)
            totalArr[k++]=nums1[i++];
        while(j<nums2.length)
            totalArr[k++]=nums2[j++];

        if(totalArr.length%2==0){
            return (double)(totalArr[totalArr.length/2]+totalArr[totalArr.length/2-1])/2;
        }
        return (double)totalArr[totalArr.length/2];
    }
}
