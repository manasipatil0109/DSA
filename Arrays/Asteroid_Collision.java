/*
735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [3,5,-6,2,-1,4]​​​​​​​
Output: [-6,2,4]
Explanation: The asteroid -6 makes the asteroid 3 and 5 explode, and then continues going left. On the other side, the asteroid 2 makes the asteroid -1 explode and then continues going right, without reaching asteroid 4.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/


package Arrays;

import java.util.Stack;

public class Asteroid_Collision {
    /*
    Solution 1 - using stack 
    */
   public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i:asteroids){
            while(!st.isEmpty() && st.peek()>0 && i<0){
                int prev = st.peek();
                if(Math.abs(prev)<Math.abs(i)){
                    st.pop();
                }else if(Math.abs(prev) == Math.abs(i)){
                    st.pop();
                    i=0;
                    break;
                }else{
                    i=0;
                    break;
                }
            }
            if(i!=0){
                st.push(i);
            }
        }
        int[] result = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            result[i]=st.pop();
        }
        return result;
    }
    
}
