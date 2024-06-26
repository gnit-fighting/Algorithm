package Hot100.easy;


/**
 * 比特位计数
 */
public class _338 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1]; //[0-n]
        int mi = 0;
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == (int) (Math.pow(2, mi))) {
                mi++;
                result[i] = 1;
            } else if ((i - 1) % 2 == 0) { //如果前一位是偶数，当前数字的 1 的个数是前一位的加 1
                result[i] = result[i - 1] + 1;
            } else if ((i - 1) % 2 == 1) { //如果前一位是奇数，当前位是偶数，与运算 + 向右位移求结果
                int cnt = 0;
                int temp = i;
                while (temp != 0) {
                    if ((temp & 1) == 1) {
                        cnt++;
                    }
                    temp = temp >> 1;
                }
                result[i] = cnt;
            }
        }
        return result;

    }
}
