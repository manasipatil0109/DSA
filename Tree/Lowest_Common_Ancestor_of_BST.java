/*
235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST. 
*/


package Tree;

import java.util.ArrayList;
import java.util.List;

public class Lowest_Common_Ancestor_of_BST {
    /*
    Solution 1 - dfs 
    */
    private void dfs(TreeNode root, TreeNode target, List<TreeNode> result){
        result.add(root);
        if(root == target)
            return;
        else if(root.val>target.val)
            dfs(root.left, target, result);
        else
            dfs(root.right, target, result);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pn = new ArrayList<>();
        dfs(root, p, pn);
        List<TreeNode> qn = new ArrayList<>();
        dfs(root, q, qn);
        TreeNode min = null;
        for(int i=0, j = 0; i<pn.size() && j<qn.size();i++,j++)
            if(pn.get(i) == qn.get(j))
                min = pn.get(i);
        return min;

    }

    /*
    Solution 2 
    */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }
}
