/*
872. Leaf-Similar Trees

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 

Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200]. 
*/


package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leaf_Similar_Trees {
    /*
    Solution 1 
    */
   private void bfs(TreeNode root, StringBuilder sb){
        if(root==null)
            return;
        if(root.left == null && root.right == null)
            sb.append(","+root.val);
        bfs(root.left,sb);
        bfs(root.right,sb);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        bfs(root1, s1);
        StringBuilder s2 = new StringBuilder();
        bfs(root2, s2);
        return s1.toString().equals(s2.toString());
    }

    /*
    //Alternative with list
    private void bfs(TreeNode root, List<Integer> s){
        if(root==null)
            return;
        if(root.left == null && root.right == null)
            s.add(root.val);
        bfs(root.left,s);
        bfs(root.right,s);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        bfs(root1, s1);
        List<Integer> s2 = new ArrayList<>();
        bfs(root2, s2);
        return s1.equals(s2);
    }
     */


    /*
    Solution 2 - non recursive 
    */
   private void treeTraversal(TreeNode root, List<Integer> l){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            if(temp.left == null && temp.right == null)
                l.add(temp.val);
            if(temp.left!=null)
                s.push(temp.left);
            if(temp.right!=null)
                s.push(temp.right);
        }
    }
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        treeTraversal(root1, s1);
        List<Integer> s2 = new ArrayList<>();
        treeTraversal(root2, s2);
        return s1.equals(s2);
    }

}
