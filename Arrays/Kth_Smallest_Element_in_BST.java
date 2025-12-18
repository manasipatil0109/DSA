/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
*/

package Arrays;

import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_BST {
    /*
    Solution 1 - takes more time 
    */
    private void preOrder(TreeNode root, PriorityQueue<Integer> pq, int k){
        if(root == null)
            return;
        preOrder(root.left, pq, k);
        pq.offer(root.val);
        if(pq.size()>k)
            pq.poll();
        preOrder(root.right, pq, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        preOrder(root, pq, k);
        return pq.poll();
    }


    /*
    Solution 2 - more optimised 
    */
    int result=-1, count=0;
    private void inOrder(TreeNode root, int k){
        if(root == null)
            return;
        inOrder(root.left, k);
        count++;
        if(k==count){
            result = root.val;
            return;
        }
        inOrder(root.right, k);
    }
    public int kthSmallest1(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }
}
