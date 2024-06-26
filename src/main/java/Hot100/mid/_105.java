package Hot100.mid;

import java.util.Arrays;

public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {

        TreeNode root = new TreeNode(preorder[pl]);
        if (pl == pr && il == ir) {
            return root;
        }
        int newir = il;
        int newril = 0;
        for (int i = il; i < inorder.length; i++) {
            if (inorder[i] == preorder[pl]) {
                newir = i - 1;
                newril = i + 1;
            }
        }

        int newpl = pl + 1;
        int newpr = newpl + (newir - il);
        int newrpl = newpr + 1;

        if(newir < il){
            root.left = null;
        }else {
            root.left = build(preorder, newpl, newpr, inorder, il, newir);
        }

        if(newril>ir){
            root.right = null;
        }else {
            root.right = build(preorder, newrpl, pr, inorder, newril, ir);

        }
        return root;
    }

    public static void main(String[] args) {
//        Arrays.copyOfRange();
    }
}
