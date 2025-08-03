/*
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 */

package Arrays;

import java.util.Arrays;
 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Sorted_Array_to_Binary_Search_Tree {

    /*
     * Solution 1
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        int mid=nums.length/2;
        System.out.println(mid);
        TreeNode curr = new TreeNode(nums[mid]);

        curr.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        curr.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        return curr;
    }

    /*
     * Solution 2
     */
    public TreeNode balanceBST(int[] nums, int l, int r){
        if(l>r)
            return null;
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = balanceBST(nums, l, mid-1);
        root.right = balanceBST(nums, mid+1, r);
        return root;
    }
    public TreeNode sortedArrayToBST1(int[] nums) {
        return balanceBST(nums,0, nums.length-1);
    }
    
}
