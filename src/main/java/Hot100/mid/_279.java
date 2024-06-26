package Hot100.mid;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.Arrays;

/**
 * 完全平方数
 */
public class _279 {
    public static void main(String[] args) {
        int i = new _279().numSquares(12);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //初始化

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        //递推
        //先遍历物品；物品的重量为 i*i
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares0(int n) {
        //dp[i] 和为 n 的完全平方数的最少数量
        //dp[1] = 1
        //递推公式：dp[i] = min{dp[i-j],dp[j]}
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // int i1 = mySqrt(i);
            double sqrt = Math.sqrt(i * 1.0);
            if ((int) sqrt == i * 1.0 / sqrt) {
                dp[i] = 1;
                continue;
            } else {
                dp[i] = i;
            }
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        return dp[n];
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1;
        int r = x / 2; //直觉上，x 的算数平方根不会超过 x/2
        int mid;
        int temp;
        while (l <= r) {
            mid = l + ((r - l) >> 2); //位移运算一定要加括号提高优先级！
            temp = x / mid; //用除法，防止溢出
            if (mid == temp) { //等价于 mid*mid = x；
                return mid;
            }
            if (mid < temp) { //等价于 mid*mid < x；
                l = mid + 1; //mid 太小了，去右边找，l=mid+1
            }
            if (mid > temp) {
                r = mid - 1;
            }
        }
        //退出循环，一定满足 l>r
        //举例分析，此时 r 就是舍去小数部分的整数
        return r;
    }
}
