/*
Same question as two sum just the array is sorted 
*/

package Arrays;

public class Two_Sum_II_Array_Sorted {
    /*
    Solution 1 - optimized 
    */
    public int[] twoSum(int[] numbers, int target) {
        int l =0, r = numbers.length-1;
        while(l<r){
            int num = numbers[l]+numbers[r];
            if(num == target)
                return new int[]{l+1,r+1};
            else if(num > target)
                r--;
            else
                l++;
        }
        return new int[]{};
    }

}
