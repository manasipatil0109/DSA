package Stack;

public class Sort_Colors {
    /*
     * Selection sort - always worst
     */
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /*
     * Bubble sort
     */
    public void sortColors1(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            boolean swap =false;
            for(int j=1;j<nums.length;j++){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
    }

    /*
     * insertion sort
     */
    public void sortColors2(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int key = nums[i];
            int j=i-1;
            while(j>=0 && key <nums[j]){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=key;
        }
    }
}
