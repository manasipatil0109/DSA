/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
*/



package Tree;

public class Binary_Tree_Maximum_Path_Sum {
    /*
    Solution 1 
    */
    int max;
    private int backtrac(TreeNode root){
        if(root == null)
            return 0;
        int val = root.val;
        int l = backtrac(root.left);
        int r = backtrac(root.right);
        root.val = Math.max(root.val,Math.max(l+val, r+val));
        max = Math.max(max, Math.max(root.val, l+r+val));
        return root.val;
    }
    public int maxPathSum(TreeNode root) {
        max=root.val;
        backtrac(root);
        return max;
    }


    /*
    Solution 2 - polished code
    */
    int max1 = Integer.MIN_VALUE;
    private int backtrac1(TreeNode root){
        if(root == null)
            return 0;
        int l = Math.max(0,backtrac1(root.left));
        int r = Math.max(0, backtrac1(root.right));
        max1 = Math.max(max1, l+r+root.val);
        return Math.max(l, r)+root.val;
    }
    public int maxPathSum1(TreeNode root) {
        backtrac1(root);
        return max;
    }
}
