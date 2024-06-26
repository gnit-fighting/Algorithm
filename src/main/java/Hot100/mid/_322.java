package Hot100.mid;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class _322 {
    public  int coinChange(int[] coins, int amount) {
        //完全背包类型题目
        //dp【j】凑成金额 j 的最少硬币数
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE || dp[amount]<0){
            return  -1;
        }
        return dp[amount];

    }
}
