package daiMaSuiXiangLu.DP;

import java.util.Scanner;

public class kama_57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i) {
                    dp[j] += dp[j - i];

                }

            }

        }
        System.out.println(dp[n]);
    }
}
