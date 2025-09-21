/*
 * 997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:
Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 
Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
 */



package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Town_Judge {
    /*
     * Solution 1 : 18 ms
     */
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
            g.get(i).add(0);
            g.get(i).add(0);
        }
        for(int i=0;i<trust.length;i++){
            List<Integer> t1 = g.get(trust[i][0]-1);
            List<Integer> t2 = g.get(trust[i][1]-1);
            t1.set(0,t1.get(0)+1);
            t2.set(1,t2.get(1)+1);
        }

        for(int i=0;i<n;i++){
            if(g.get(i).get(0) == 0 && g.get(i).get(1) == n-1)
                return i+1;
        }
        return -1;
    }

    /*
     * Solution 2: faster
     */
    public int findJudge1(int n, int[][] trust) {
        int[] inbound= new int[n];
        int[] outbound = new int[n];
        for(int i=0;i<trust.length;i++){
            inbound[trust[i][1]-1]+=1;
            outbound[trust[i][0]-1]+=1;
        }
        for(int i=0;i<n;i++){
            if(inbound[i]==n-1 && outbound[i]==0)
                return i+1;
        }
        return -1;
    }
}
