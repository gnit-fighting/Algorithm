package daiMaSuiXiangLu.DP;

import java.util.Scanner;

public class kama52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int bagsize = scanner.nextInt();
        int[] weight = new int[len + 1];
        int[] values = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        int[] dp = new int[bagsize + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j - weight[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);

                }
            }
        }
        System.out.println(dp[bagsize]);
    }

}
