/*
 * 145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */



package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Postorder_Traversal {
    
    /*
     * Solution 1 - recursive
     */
    private void postOrder(TreeNode root, List<Integer> l){
        if(root == null)
            return;
            postOrder(root.left, l);
            postOrder(root.right, l);
            l.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        postOrder(root, l);
        return l;
    }

    /*
     * Solution 2 - non recursive - stack, reverse
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root==null)
            return l;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            l.add(temp.val);
            if(temp.left!=null)
                st.push(temp.left);
            if(temp.right!=null)
                st.push(temp.right);

        }
        Collections.reverse(l);
        return l;
    }
}
