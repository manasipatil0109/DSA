/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree. 
*/



package Tree;

import java.util.HashMap;
import java.util.Map;

public class Construct_BT_from_Preorder_and_Inorder_Traversal {
    /*
    Solution 1 
    */
    int prei = 0;
    private TreeNode build(int[] preorder, int l, int r, Map<Integer, Integer> hm){
        if(l>r)
            return null;
        int index = hm.get(preorder[prei]);
        TreeNode curr = new TreeNode(preorder[prei]);
        prei++;
        curr.left = build(preorder, l, index-1, hm);
        curr.right = build(preorder, index+1, r, hm);
        return curr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);
        return build(preorder, 0, preorder.length-1, hm);
    }
}
