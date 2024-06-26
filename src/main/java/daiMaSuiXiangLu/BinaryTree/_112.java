package daiMaSuiXiangLu.BinaryTree;

import java.util.Stack;

/**
 * 路径总和
 */
public class _112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //前序遍历=递归+回溯
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum =0;
        while (!stack.isEmpty()) {
            //遍历中 - 出栈
            TreeNode pop = stack.pop();
            sum+=pop.val;



            // 右孩子先入栈 【先进后出】
            if (pop.right != null) {
                stack.push(pop.right);
            }

            //左孩子入栈
            if(pop.left!=null){
                stack.push(pop.left);
            }

        }

        return false;
    }
}
