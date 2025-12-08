/*
 * 104. Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2
 */

package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class max_depth {

    /*
    Solution 1 
    */
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int l=maxDepth(root.left)+1;
        int r=maxDepth(root.right)+1;
        return l>r?l:r;
    }

    /*
    Solution 2 
    */
   public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            } 
        }
        return level;
    }
}
