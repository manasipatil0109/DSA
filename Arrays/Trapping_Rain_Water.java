/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105 
*/




package Arrays;

public class Trapping_Rain_Water {
    /*
    Solution 1 - but time limit exceed 
    */
    public int trap(int[] height) {
        int water = 0;
        for(int i=0;i<height.length;i++){
            int lmax = height[i];
            for(int j=0;j<i;j++){
                if(lmax<height[j])
                    lmax = height[j];
            }

            int rmax = height[i];
            for(int j=i+1;j<height.length;j++){
                if(rmax<height[j])
                    rmax = height[j];
            }

            water+=Math.min(lmax, rmax)-height[i];
        }
        return water;
    }

    /*
    Solution 2 - optimized
    */
    public int trap1(int[] height) {

        int left = 0, right = height.length-1;
        int lmax = 0, rmax = 0;
        int water = 0;
        while(left<right){
            if(height[left]< height[right]){
                if(height[left]>=lmax)
                    lmax = height[left];
                else
                    water+=lmax-height[left];
                left++;
            }else{
                if(height[right]>=rmax)
                    rmax = height[right];
                else
                    water+=rmax-height[right];
                right--;
            }
        }
        return water;

    }
}
