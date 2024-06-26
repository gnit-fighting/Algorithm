package Hot100.easy;

public class _543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = getDepth(root.left);
        int rightdepth = getDepth(root.right);
        ans = Math.max(ans, leftdepth + rightdepth);

        return Math.max(leftdepth, rightdepth) + 1;
    }
}
