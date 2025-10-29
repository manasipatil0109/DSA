/*
 * 144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */


package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder_Traversal {
    /*
     * Solution 1- recursion
     */
    private void preOrder(TreeNode root, List<Integer> l){
        if(root==null)
            return;
        l.add(root.val);
        preOrder(root.left,l);
        preOrder(root.right,l);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        preOrder(root,l);
        return l;
    }

    /*
     * Solution 2- non recursive
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root==null)
            return l;
        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        while(!q.isEmpty()){
            TreeNode curr = q.pop();
            if(curr!=null){
                l.add(curr.val);
                q.push(curr.right);
                q.push(curr.left);
            }

        }
        return l;
    }
}
