package daiMaSuiXiangLu.DP;

/**
 * 最后一块石头的重量 II
 */
public class _1049 {
    public int lastStoneWeightII(int[] stones) {
        //可用 分割等和子集来解决（01背包变形）
        int sum = 0;
        for(int i :stones) {
            sum+=i;
        }
        int bagWeight = sum/2;//背包容量
        int[] dp = new int[bagWeight+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagWeight; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        int another = sum - dp[bagWeight];

        return another-dp[bagWeight];

    }
}
