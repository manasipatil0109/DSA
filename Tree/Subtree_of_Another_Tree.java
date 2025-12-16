/*
572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104 
*/



package Tree;

import java.util.Stack;

public class Subtree_of_Another_Tree {
    
    private boolean isEqual(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null || root.val!=subRoot.val)
            return false;
        return isEqual(root.left,subRoot.left) && isEqual(root.right,subRoot.right); 
    }

    /*
    Solution 1 - not optimized , non recursive
    */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            if(root.val == subRoot.val){
                boolean res = isEqual(root,subRoot);
                if(res)
                    return res;
            }
            if(root.left!=null)
                st.push(root.left);
            if(root.right!=null)
                st.push(root.right);
        }
        return false;
    }



    /*
    Solution 2 - recursive 
    */
   public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        if(root.val == subRoot.val){
            if(isEqual(root,subRoot))
                return true;
            else
                return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);

        } else{
            return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
        }
    }
}
