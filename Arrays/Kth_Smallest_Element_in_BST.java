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
