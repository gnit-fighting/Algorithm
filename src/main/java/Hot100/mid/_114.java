package Hot100.mid;


import apple.laf.JRSUIUtils;

/**
 * 二叉树展开为链表
 */
public class _114 {
    public static void main(String[] args) {
        //[1,2,5,3,4,null,6]
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node1 = new TreeNode(1, node2, node5);
        new _114().flat(node1);
    }

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        flat(root);
    }

    //返回值 ： 展开以 root 为根的树后，本树的最右下的节点
    public TreeNode flat(TreeNode root) {
        //如果 root 没有左右孩子，就返回自己
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return root;
        }

        TreeNode leftLast;
        if (left != null) {
            leftLast = flat(left);
        } else {
            leftLast = root;
        }

        //把展开后的左子树 作为 根的右孩子
        root.left = null;
        root.right = left;

        TreeNode rightLast;
        if (right != null) {
            rightLast = flat(right);
        } else {
            rightLast = leftLast;
        }

        //把展开后的右子树挂到左子树的最右下
        leftLast.right = right;

        return rightLast;
    }
}
