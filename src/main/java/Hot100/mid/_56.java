package Hot100.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 */
public class _56 {
    public int[][] merge(int[][] intervals) {

        //1.对 intervals 数组排序，区间开始小的在前面， v1[0]-v2[0] 返回负数，则 v1在 v2前面
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];
        int idx = -1;

        for (int[] interval : intervals) {
            if (idx == -1 || result[idx][1] < interval[0]) {
                result[++idx] = interval;
            } else {
                result[idx][1] = Math.max(interval[1], result[idx][1]);
            }

        }
        return Arrays.copyOf(result, idx + 1);
    }
}
