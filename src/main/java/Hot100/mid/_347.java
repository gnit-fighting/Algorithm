package Hot100.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1[1] - o2[1]; //返回负数，o1在 o2前面
                }
        );
        for (Map.Entry entry : map.entrySet()) {
            int[] now = new int[]{(Integer)entry.getKey(), (Integer)entry.getValue()};
            if (priorityQueue.size() < k) {
                priorityQueue.add(now);
            } else {
                if (now[1] > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.add(now);
                }
            }
        }

        int[] ans = new int[k];
        int i=0;
        while (!priorityQueue.isEmpty()){
            ans[i++] = priorityQueue.poll()[0];
        }

        return ans;
    }
}
