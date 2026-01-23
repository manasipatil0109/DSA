/*
530. Minimum Absolute Difference in BST
Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/ 

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
*/


package Tree;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Absolute_Difference_in_BST {
    /*
    Solution 1 - with more time complexity
    */
    private void inorder(TreeNode root, List<Integer> l){
        if(root==null)
            return;
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<l.size();i++){
            int val = l.get(i)-l.get(i-1);
            if(val<min){
                min= val;
            }
            if(min == 1)
                return min;
        }
        return min;
    }


    /*
    Solution 2 - faster
    */
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null)
            min = Math.min(min, root.val-prev);
        prev = root.val;
        inorder(root.right);
    }
    public int getMinimumDifference1(TreeNode root) {
        inorder(root);
        return min;
    }
    
}
