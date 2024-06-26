package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出最长等值子数组
 */
public class _2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posList = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) {
            Integer i1 = nums.get(i);
            if (posList[i1] == null) {
                posList[i1] = new ArrayList<>();
            }
            posList[i1].add(i);
        }

        int left;
        int right;
        int result = 0;
        for (List<Integer> pos : posList) {
            if (pos == null) {
                continue;
            }
            if (pos.size() <= result) {
                continue; //无法让 result 变得更大
            }
            left = 0;
            for (right = 0; right < pos.size(); right++) {
                while (pos.get(right) - pos.get(left) - (right - left) > k) {
                    left++; //滑动窗口
                }
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
