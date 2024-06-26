package Hot100.mid;

/**
 * 组合总和 IV
 */
public class _377 {
    public int combinationSum4(int[] nums, int target) {
        //完全背包 - 求排列的模型
        // 这里用动态规划更高效 - 因为并不需要列出组合的具体情况；只是求组合（本题是排列）个数
        int[] dp = new int[target +1];
        dp[0] =1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(j>=nums[i]){
                    dp[j]  += dp[j-nums[i]];

                }
            }
        }
        return  dp[target];
    }
}
