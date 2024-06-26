package Hot100.mid;

/**
 * 除自身之外数组的乘积
 */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];

        //计算左部分的乘积
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] result = new int[len];
        //计算右部分的乘积
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + 1 < len) {
                right *= nums[i + 1];
            }
            result[i] = left[i] * right;

        }

        return result;

    }
}
