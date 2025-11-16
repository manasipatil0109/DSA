/*
 * 256. Paint House
** Google **
You have n houses arranged in a row, and each house must be painted with one of three colors: red, blue, or green. The challenge is that no two adjacent houses can have the same color.

You're given a cost matrix costs with dimensions n x 3, where:

costs[i][0] represents the cost to paint house i with red
costs[i][1] represents the cost to paint house i with blue
costs[i][2] represents the cost to paint house i with green
Your task is to find the minimum total cost to paint all houses while ensuring that no two neighboring houses share the same color.

For example, if you have 3 houses with costs:

House 0: red=17, blue=2, green=17
House 1: red=16, blue=16, green=5
House 2: red=14, blue=3, green=19
You need to choose one color for each house such that the total cost is minimized and adjacent houses have different colors. In this case, one optimal solution would be to paint house 0 blue (cost 2), house 1 green (cost 5), and house 2 blue (cost 3), for a total minimum cost of 10.
 */


package Arrays;

public class Paint_House {

    public static int minCost(int[][] costs){
        int n = costs.length;
        if(costs == null || n==0)
            return 0;
        for(int i=1;i<n;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][2]);           
        }

        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
    }


    /*
     * Solution Wrong - This is greedy approach. But it fails 
     * {
            {1, 100, 2},
            {2, 100, 100},
            {100, 1, 100}
        }
     */
    public static int minCost2(int[][] costs){
        int prev = costs[0][0]>costs[0][1]?(costs[0][1]>costs[0][2]?2:1):0;
        int cost = costs[0][prev];
        for(int i=1;i<costs.length;i++){
            if(prev==0){
                prev = costs[i][1]>costs[i][2]?2:1;
            }else if(prev==1){
                prev = costs[i][0]>costs[i][2]?2:0;
            }else{
                prev = costs[i][0]>costs[i][1]?1:0;
            }
            cost+=costs[i][prev];
        }
        return cost;
    }

    public static void main(String[] args){
        int[][] costs = {
            {1, 100, 2},
            {2, 100, 100},
            {100, 1, 100}
        };
        System.out.println("Cost: "+ minCost(costs));
    }
}
