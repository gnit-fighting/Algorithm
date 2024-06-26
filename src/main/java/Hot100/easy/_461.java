package Hot100.easy;

/**
 * 汉明距离
 */
public class _461 {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int cnt = 0;
        while (result != 0) {
            if ((result & 1) == 1) {
                cnt++;
            }
            result = result >> 1;
        }
        return cnt;
    }
}
