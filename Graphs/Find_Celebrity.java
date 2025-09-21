/*
 * 277. Find the Celebrity
 * 
At a party, there are n people labeled from 0 to n - 1. There is a rumor that one of these people is secretly the celebrity.

If the celebrity exists, then:
1. The celebrity knows nobody.
2. Everybody (except for the celebrity) knows the celebrity.
3. There is exactly one person that satisfies properties 1 and 2.

You are given a helper API knows(a, b) which returns true if person a knows person b, and false otherwise.
Implement a function findCelebrity(n) that returns the label of the celebrity if the celebrity exists and 
can be identified, or returns -1 otherwise.

Example 1:
Input: n = 3
Hidden knowledge matrix:
    0 knows 1, 0 knows 2
    1 knows nobody
    2 knows 1
Output: 1

Example 2:
Input: n = 3
Hidden knowledge matrix:
    0 knows 1
    1 knows 0
    2 knows 0
Output: -1

Constraints:

1 <= n <= 1000

At most one celebrity exists

The knows(a, b) API is defined for you (you cannot directly access the knowledge matrix)
 */




package Graphs;

public class Find_Celebrity {

    /* The knows API is defined in the parent class Relation.*/
    boolean knows(int a, int b){
        return false;/* temporary code */
    }
     
    /*
     * Solution 1 - This is the best optimised solution
     */
    public int findCelebrity(int n) {
        int candidate=0;
        for(int i=1;i<n;i++){
            if(knows(candidate,i))
                candidate=i;
        }
        for(int i=0;i<n;i++){
            if(knows(candidate,i) && !knows(i,candidate)){
                return -1;
            }
        }
        return candidate;
    }

    /*
     * Solution 2
     */
    public int findCelebrity1(int n){
        for(int i=0;i<n;i++){
            boolean isC =true;
            for(int j=0;j<n;j++){
                if(1!=j && knows(i,j)){
                    isC=false;
                    break;
                }
            }

            if(isC){
                for(int j=0;j<n;j++){
                    if(i!=j && !knows(j,i)){
                        isC=false;
                        break;
                    }
                }
            }

            if(isC)
                return i;
        }
        return -1;
    }
}
