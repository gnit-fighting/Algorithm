package daiMaSuiXiangLu.DP;

/**
 * 零钱兑换 II
 */
public class _518 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        new _518().change(5,coins);

    }
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //组合数
//        for (int i = 0; i < coins.length; i++) {
//            for (int j = coins[i]; j <= amount; j++) {
//                    dp[j] += dp[j - coins[i]];
//            }
//            for (int j = 0; j <=amount; j++) {
//                System.out.print(" "+dp[j]);
//            }
//            System.out.println();
//
//        }

        //排列数
        for (int j = 0; j <=amount; j++) {
            for (int i = 0; i <coins.length; i++) {
                if(j>=coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
            for (int i = 0; i <=amount; i++) {
                System.out.print(" "+dp[i]);
            }
            System.out.println();

        }
        return dp[amount];
    }
}
