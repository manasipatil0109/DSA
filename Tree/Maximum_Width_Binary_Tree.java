/*
 * 662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 */


package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_Binary_Tree {
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode n, long i) {
            node = n;
            index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        long width=0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while(!q.isEmpty()){
            int limit = q.size();
            long start = q.peek().index;
            long end = start;
            for(int i=0;i<limit;i++){
                Pair curr = q.poll();
                TreeNode n = curr.node;
                end = curr.index;
                if(n.left!=null)
                    q.offer(new Pair(n.left,curr.index*2));
                if(n.right!=null)
                    q.offer(new Pair(n.right,curr.index*2+1));
            }
            width = Math.max(width, end-start+1);

        }
        return (int)width;
    }
}
