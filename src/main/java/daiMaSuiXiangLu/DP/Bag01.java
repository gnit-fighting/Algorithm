package daiMaSuiXiangLu.DP;

import java.util.Scanner;

public class Bag01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();//物品种类
        int N = scanner.nextInt();//背包容量
        int[] weight = new int[M];
        for (int i = 0; i < M; i++) {
            weight[i] = scanner.nextInt();
        }
        int[] value = new int[M];
        for (int i = 0; i <M ; i++) {
            value[i] = scanner.nextInt();
        }

        //=======================
        //二维 dp 数组实现
        //初识化 dp 数组
//        int[][] dp = new int[M][N+1];
//        for (int j = weight[0]; j <= N ; j++) {
//            dp[0][j] = value[0];
//        }
//
//        //遍历，注意 i 和 j 从 1 开始了
//        for (int i = 1; i < M; i++) { //先遍历物品
//            for (int j = 1; j <= N; j++) { //再遍历背包
//                if(j-weight[i]>=0){
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
//                }else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        System.out.println(dp[M-1][N]);


        //===========================
        //一唯dp 数组实现
        int[] dp=new int[N+1];

        for (int i = 0; i < M; i++) {
            for (int j = N; j >=weight[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[N]);


    }

}
