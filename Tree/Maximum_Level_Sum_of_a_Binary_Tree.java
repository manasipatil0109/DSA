/*
1161. Maximum Level Sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
*/



package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Maximum_Level_Sum_of_a_Binary_Tree {
    /*
    Solution 1 
    */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> st = new ArrayDeque<>();
        st.offer(root);
        int max = Integer.MIN_VALUE;
        int level = 0;
        int maxlevel = 0;
        while(!st.isEmpty()){
            int size = st.size();
            level++;
            int currMax = 0;
            while(size>0){
                TreeNode curr = st.poll();
                if(curr.left!=null)
                    st.offer(curr.left);
                if(curr.right!=null)
                    st.offer(curr.right);
                currMax+=curr.val;
                size--;
            }
            System.out.println(currMax+" ");
            if(max<currMax){
                max = currMax;
                maxlevel = level;
            }
        }
        return maxlevel;
    }
}
