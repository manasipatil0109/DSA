/*
Same question as two sum just the array is sorted 
*/

package Arrays;

import java.util.HashMap;

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

    /*
    Solution 2 - more time than prev 
    */
    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(hm.containsKey(target-numbers[i])){
                return new int[]{hm.get(target-numbers[i]),i+1};
            }else{
                hm.put(numbers[i],i+1);
            }
        }
        return null;
    }
}
