package Hot100.mid;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return  result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        List<Integer> itemList ;
        while (!queue.isEmpty()){
            int len = queue.size();
            itemList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                itemList.add(poll.val);

                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }

            }
            result.add(itemList);
        }
        return  result;
    }
}
