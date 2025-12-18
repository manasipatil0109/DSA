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
}
