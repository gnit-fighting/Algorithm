package Hot100.easy;

import javax.swing.tree.TreeCellRenderer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 */
public class _104 {
    public int maxDepth(TreeNode root){
        //return getDepthByLevel(root);
        return getDepthByPost(root);

    }

    //后序遍历【递归】
    public   int  getDepthByPost(TreeNode root){
        if(root==null){
            return  0;
        }
        int left = getDepthByPost(root.left);
        int right = getDepthByPost(root.right);

        return 1+Math.max(left,right) ;
    }



    //层序遍历
    public  int  getDepthByLevel(TreeNode root){
        if(root==null){
            return  0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0 ;
        while (!queue.isEmpty()){
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            depth++;


        }

        return  depth;
    }

}
