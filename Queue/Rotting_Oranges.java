/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2. 
*/




package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    /*
    Solution 1 
    */
    int min=0;
    private void bfs(int[][] grid, int fresh, Queue<int[]> q){
        if(q.isEmpty()){
            if(fresh>0)
                min=-1;
            return;
        }
        int size = q.size();
        boolean rottedThisMinute = false;
        while(size>0){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int[] d:dirs){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr, nc});
                    fresh--;
                    rottedThisMinute=true;
                }
            }
            size--;
        }
        if(rottedThisMinute)
            min++;
        bfs(grid, fresh, q);
    }
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
            }
        }
        if(fresh == 0)
            return 0;
        bfs(grid, fresh, q);
        return min;
    }
}
