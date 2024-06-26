package daiMaSuiXiangLu.DP;

public class _474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : charArray) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }

            }

        }

        return dp[m][n];
    }
}
