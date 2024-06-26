package Hot100.mid;

import java.util.HashMap;
import java.util.Map;

public class _437 {
    long s;//当前路径的和
    Map<Long, Integer> cnt = new HashMap<>(); //k:前缀和 v：计数

    int ans;//存储路径和等于给定目标和的路径数量

    public int pathSum(TreeNode root, int targetSum) {
        //注意：前缀和 0 的计数初识化为 1，把任意路径和都表示成两个前缀和的差
        cnt.put(0L, 1);
        dfs(root, 0, cnt, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, long s, Map<Long, Integer> cnt, int targetSum) {
        if (root == null) {
            return;
        }
        s += root.val;
        ans += cnt.getOrDefault(s - targetSum, 0);
        cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        dfs(root.left, s, cnt, targetSum);
        dfs(root.right, s, cnt, targetSum);
        cnt.put(s, cnt.get(s) - 1); //恢复现场
    }


    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(10, node5, node3);

    }

}
