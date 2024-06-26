package Hot100.mid;

import java.util.Scanner;

public class kama_56 {
    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        int bagSize = scanner.nextInt();
        int[] dp = new int[bagSize + 1];
        int N = scanner.nextInt();
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = scanner.nextInt();
        }
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = scanner.nextInt();
        }
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        //多重背包（本质可以理解为 01背包）
        for (int i = 0; i < N; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                for (int k = 1; k <= nums[i] && j - k * weight[i] >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }

        System.out.println(dp[bagSize]);

    }
}
