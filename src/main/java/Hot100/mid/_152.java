package Hot100.mid;

/**
 * 乘积最大子数组
 */
public class _152 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 3, -4};
        int i = maxProduct(nums);
    }

    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp1 = new int[len];//dp1[i]!=-1
        int[] dp2 = new int[len];//dp2[i]!=0
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                dp1[i] = nums[i];
                dp2[i] = 0;
                ans = Math.max(ans, dp1[i]);
            } else {
                dp2[i] = nums[i];
                dp1[i] = -1;
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                if (dp1[i - 1] != -1) {
                    dp1[i] = Math.max(dp1[i], dp1[i - 1] * nums[i]);
                    ans = Math.max(ans, dp1[i]);

                }
                if (dp2[i - 1] != 0) {
                    dp2[i] = Math.min(dp2[i], dp2[i - 1] * nums[i]);
                }
            }
            if (nums[i] < 0) {
                if (dp1[i - 1] != -1) {
                    dp2[i] = Math.min(dp2[i], dp1[i - 1] * nums[i]);

                }
                if (dp2[i - 1] != 0) {
                    dp1[i] = Math.max(dp1[i], dp2[i - 1] * nums[i]);
                    ans = Math.max(ans, dp1[i]);

                }
            }
        }
        return ans;
    }
}
