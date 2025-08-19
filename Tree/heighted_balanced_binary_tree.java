/*
 * 110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced. 

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true
 */


package Tree;

public class heighted_balanced_binary_tree {
    public int isHeighted(TreeNode root){
        if(root==null)
            return 0;
        int l = isHeighted(root.left);
        if(l==-1)
            return -1;
        int r = isHeighted(root.right);
        if(r==-1)
            return -1;
        if(Math.abs(l-r)>1)
            return -1;
        else
            return (l>r?l:r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(isHeighted(root)==-1)
            return false;
        return true;
    }
}
