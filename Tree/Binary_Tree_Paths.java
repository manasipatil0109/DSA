/*
257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100 
*/



package Tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
    /*
    Solution 1 
    */
    private void backtrac(TreeNode root, List<String> ans, StringBuilder sb){
        int len = sb.length();
        sb.append(root.val);
        if(root.left== null && root.right == null){
            ans.add(sb.toString());
        }else{
            sb.append("->");
            if(root.left!=null)
                backtrac(root.left, ans, sb);
            if(root.right!=null)
                backtrac(root.right, ans, sb);
        }
        sb.setLength(len);
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        backtrac(root, ans, new StringBuilder());
        return ans;
    }
}
