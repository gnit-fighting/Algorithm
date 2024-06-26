package Hot100.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 */
public class _560 {
    //前缀和 + 哈希表
    public int subarraySum(int[] nums, int k) {
        //计算前缀和
        int[] s = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i]+nums[i];
        }

        //哈希表统计计数
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (Integer sj :s) {
            cnt += map.getOrDefault(sj-k,0);
            map.put(sj,map.getOrDefault(sj,0)+1);
        }
        return  cnt;


    }


    //暴力法
    public int subarraySum0(int[] nums, int k) {

        if (nums == null) {
            return 0;
        }
        int subSum;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            subSum = 0;
            for (int j = i; j < nums.length; j++) {
                subSum += nums[j];
                if (subSum == k) {
                    cnt++;
                    //这里中途找到了和为 k 的子数组后，不能直接 break 了！
                    //可能后面还有（因为可以抵消，数组是无序的，且可能有负数）

                }
            }

        }
        return cnt;

    }
}
