package Hot100.hard;

import Hot100.mid.TreeNode;

public class _124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) {
            return 0 ;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        ans =  Math.max(left + right + root.val ,ans);
        return Math.max(0,Math.max(left,right)+root.val);
    }
}
