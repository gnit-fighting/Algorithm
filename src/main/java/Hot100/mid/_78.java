package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class _78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new _78().subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        //result 结果中假如空集
        backtracking(nums, 0);
        return result;

    }

    public void backtracking(int[] nums, int start) {
        //对当前 path收集结果
        result.add(new ArrayList<>(path));
        // 如果开始下标大于等于 len  -- 递归结束
        if (start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
