package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_I {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                curr.add(temp.val);
            }
            res.add(curr);
        }
        return res;
    }
}
