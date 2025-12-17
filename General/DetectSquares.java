/*
2013. Detect Squares

You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
 

Example 1:


Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points
 

Constraints:

point.length == 2
0 <= x, y <= 1000
At most 3000 calls in total will be made to add and count. 
*/



package General;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    /*
    Solution 1 - very time complex
    */
    Map<Integer, List<Integer>> points;

    public DetectSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        if(points.containsKey(point[0])){
            points.get(point[0]).add(point[1]);
        }else{
            List<Integer> p = new ArrayList<>();
            p.add(point[1]);
            points.put(point[0],p);
        }
    }
    
    public int count(int[] point) {
        int x = point[0], y = point[1];
        if(!points.containsKey(x))
            return 0;
        List<Integer> yCoor = points.get(x);
        int count=0;
        for(int y2 : yCoor){
            int length = Math.abs(y-y2);
            if(length == 0)
                continue;

            //negative length
            int x1 = x-length;
            if(x1>=0 && points.containsKey(x1)){
                List<Integer> yx1 = points.get(x1);
                int y2check=0;
                int ycheck=0;
                for(int cy:yx1){
                    if(cy == y2)
                        y2check++;
                    if(cy == y)
                        ycheck++;
                }
                count+=ycheck*y2check;
            }

            //positive length
            x1 = x+length;
            if(x1>=0 && points.containsKey(x1)){
                List<Integer> yx1 = points.get(x1);
                int y2check=0;
                int ycheck=0;
                for(int cy:yx1){
                    if(cy == y2)
                        y2check++;
                    if(cy == y)
                        ycheck++;
                }
                count+=ycheck*y2check;
            }
        }
        return count;
    }


}
