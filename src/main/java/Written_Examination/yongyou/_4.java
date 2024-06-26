package Written_Examination.yongyou;

import java.util.Arrays;

/**
 * leetcode 1751
 */
public class _4 {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,3},{3,4,2},{2,4,6}};
        maxValue(array,2);
    }
    public  static  int maxValue (int[][] interviews, int k) {
        // write code here
        //按开始时间排序
        Arrays.sort(interviews,(o1,o2)->{
            return  o1[0] - o2[0];
        });
        int len = interviews.length;
        int[] dp = new int[len];
        dp[0] = interviews[0][2];
        for (int i = 1; i <len ; i++) {
            for (int j = i-1; j >= 0  ; j--) {
                if(interviews[i][0] > interviews[j][1]){
                    int temp = Math.max(dp[i],dp[i-1]+interviews[i][2]);
                    dp[i] = Math.max(dp[i],temp);

                }
            }
        }
        return  dp[len-1];
    }
}
