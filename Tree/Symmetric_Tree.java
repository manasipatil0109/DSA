/*
 * 101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */

package Tree;


public class Symmetric_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if((p!=null && q==null) || (p==null && q!=null))
            return false; 
        if(p==null && q == null)
            return true;
        return (p.val==q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left));
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSameTree(root.left,root.right);
    }
}
