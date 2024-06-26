package Hot100.easy;

/**
 * 只出现一次的数字
 */
public class _136 {
    public int singleNumber(int[] nums) {
        //技巧题 -  异或
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
