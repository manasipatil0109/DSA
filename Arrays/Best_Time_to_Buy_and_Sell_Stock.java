package Arrays;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i:prices){
            if(i<min)
                min=i;
            else
                max=Math.max(max,i-min);
        }
        return max;
    }
}
