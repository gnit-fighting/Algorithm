package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 */
public class _236 {
    List<TreeNode> path = new ArrayList<>(); //记录当前路径
    List<TreeNode> ppath; //记录根节点到 p 的路径
    List<TreeNode> qpath; //记录根节点到 q 的路径

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, path, p, q);
        //检查 p、q 的路径：找到第一个不同的节点的前一个节点就是最近公共祖先
        int i, j;
        for (i = 0, j = 0; i < ppath.size() && j < qpath.size(); ) {
            if (ppath.get(i) == qpath.get(j)) {
                i++;
                j++;
            } else {
                return ppath.get(i - 1);
            }
        }
        if (i == ppath.size()) {
            return ppath.get(ppath.size() - 1);
        }
        if (j == qpath.size()) {
            return qpath.get(qpath.size() - 1);
        }
        return root;
    }

    //深度优先遍历；记录 p、q 的路径
    public void dfs(TreeNode root, List<TreeNode> path, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root == p) {
            ppath = new ArrayList<>(path);
        }
        if (root == q) {
            qpath = new ArrayList<>(path);
        }

        dfs(root.left, path, p, q);
        dfs(root.right, path, p, q);
        path.remove(path.size() - 1); //恢复现场
    }

    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;

    }
}
