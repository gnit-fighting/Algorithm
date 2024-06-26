package Hot100.mid;

import java.util.HashSet;
import java.util.Set;

public class _128 {
    public int longestConsecutive(int[] nums) {
        //遍历数组，放到 set 中
        if (nums == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        //遍历 set，看当前元素 cur 的前一个在不在、后一个在不在，计数
        int res = 0;
        for (Integer num : set) {
            //set查找元素的时间复杂度为 O(1)
            int subLength = 0;
            if (!set.contains(num - 1)) {//前一个统计过了的话，该元素不用重复处理了
                subLength = 1; //计数当前元素
                while (set.contains(++num)) subLength++;
                res = res > subLength ? res : subLength;
            }
        }
        return res;
    }
}
