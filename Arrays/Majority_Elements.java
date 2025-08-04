package Arrays;

import java.util.HashMap;

public class Majority_Elements {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i)){
                hm.replace(i,hm.get(i)+1);
            } else{
                hm.put(i,1);
            }
            if(hm.get(i)>nums.length/2)
                return i;
        }
        return 0;
    }
}