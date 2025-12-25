/*
1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.
 

Constraints:

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4]. 
*/


package Tree;

import java.util.Stack;

public class Count_Good_Nodes_in_Binary_Tree {
    /*
    Solution 1 
    */
    int ans = 0;
    private void preOrder(TreeNode root, int max){
        if(root==null)
            return;
        if(root.val>=max)
            ans++;
        preOrder(root.left, Math.max(max, root.val));
        preOrder(root.right, Math.max(max, root.val));
    }
    public int goodNodes(TreeNode root) {
        preOrder(root, root.val);
        return ans;
    }


    /*
    Solution 2 - using stack 
    */
    public int goodNodes1(TreeNode root) {
        int count = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        count++;
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.left!=null){
                if(curr.left.val >= curr.val)
                    count++;
                curr.left.val = Math.max(curr.left.val, curr.val);
                st.push(curr.left);
            }
            if(curr.right!=null){
                if(curr.right.val >= curr.val)
                    count++;
                curr.right.val = Math.max(curr.right.val, curr.val);
                st.push(curr.right);
            }
        }
        return count;
    }


    /*
    Solution 2 - optimized stack 
    */
    public int goodNodes2(TreeNode root) {
        int count = 0;
        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> max = new Stack<>();
        st.push(root);
        max.push(root.val);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            int m = max.pop();
            if(curr.val>=m){
                count++;
                m = Math.max(curr.val,m);
            }
            if(curr.left!=null){
                st.push(curr.left);
                max.push(m);
            }
            if(curr.right!=null){
                st.push(curr.right);
                max.push(m);
            }

        }
        return count;
    }
    
}
