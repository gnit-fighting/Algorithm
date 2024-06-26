package Hot100.easy;

/**
 * 翻转二叉树
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {

        invert(root);
        return null;

    }

    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
