/*
 * 297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */


package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize_Binary_Tree {
    /*
     * Solution 1- without recursion
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null)
            return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode t = list.poll();
            if(t==null){
                s.append("null,");
                continue;
            }
            s.append(t.val+",");
            list.add(t.left);
            list.add(t.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] ch = data.split(",");
        TreeNode head = new TreeNode(Integer.valueOf(ch[0]));
        Queue<TreeNode> list = new LinkedList<>();
        list.add(head);
        int i=1;
        while(!list.isEmpty() && i < ch.length){
            TreeNode curr = list.poll();
            if(!ch[i].equals("null")){
                curr.left=new TreeNode(Integer.valueOf(ch[i]));
                list.add(curr.left);
            }
            i++;
            if(!ch[i].equals("null")){
                curr.right=new TreeNode(Integer.valueOf(ch[i]));
                list.add(curr.right);
            }
            i++;
        }
        return head;
    }


    /*
     * Solution 2 - recursion
     */
    private void preOrder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("na");
            return;
        }
        sb.append(root.val);
        sb.append("a");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }


    private TreeNode preOrderFormD(Queue<String> q){
        String curr = q.poll();
        if(curr.equals("n")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(curr));
        head.left = preOrderFormD(q);
        head.right = preOrderFormD(q);
        return head;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] c = data.split("a");
        Queue<String> q = new LinkedList<>(Arrays.asList(c));
        return preOrderFormD(q);
    }
}
