/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin. 
*/




package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Min_Stack {
    /*
    Solution 1 - the min find is O(n), expected is O(1) 
    */
    class MinStack {
        List<Integer> stack;
        public MinStack() {
            stack = new ArrayList<>();
        }
        
        public void push(int val) {
            stack.add(val);
        }
        
        public void pop() {
            stack.remove(stack.size()-1);
        }
        
        public int top() {
            return stack.get(stack.size()-1);
        }
        
        public int getMin() {
            int min = Integer.MAX_VALUE;
            for(int i:stack){
                if(i<min)
                    min = i;
            }
            return min;
        }
    }


    /*
    Solution 2 - with all O(1) 
    */
   class MinStack1 {
        Stack<Integer> st;
        Stack<Integer> mst;
        public MinStack1() {
            st = new Stack<>();
            mst = new Stack<>();
        }
        
        public void push(int val) {
            st.push(val);
            if(mst.isEmpty() || mst.peek()>=val)
                mst.push(val);
        }
        
        public void pop() {
            if(st.pop().equals(mst.peek()))
                mst.pop();
        }
        
        public int top() {
            return st.peek();
        }
        
        public int getMin() {
            return mst.peek();
        }
    }
}
