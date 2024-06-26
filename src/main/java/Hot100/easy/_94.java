package Hot100.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //递归实现中序遍历 （前序、后序模板类似，不过是访问节点的顺序问题）
        //digui(root,result);

        diedai(root, result);
        return result;
    }

    public void diedai(TreeNode root, List<Integer> result) {
        //迭代版本 - 用 stack 模拟递归的过程[背吧！]
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;


        //先不断往左走
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //直到碰到叶子节点，访问中(栈顶元素出栈)
            if (cur == null) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                //访问该子树的右子树（访问右子树时，还是先往左一直走，访问中，访问右孩子）
                cur = pop.right;
            }
        }
    }


    public void digui(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        digui(root.left, result);
        result.add(root.val);
        digui(root.right, result);
    }
}
