package Hot100.mid;

/**
 * 最大子数组和（最大子序和）
 */
public class _53 {
    public int maxSubArray(int[] nums) {
        //动态规划
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
}
