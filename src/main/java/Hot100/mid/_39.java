package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class _39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int min = Integer.MAX_VALUE;
        for (int i : candidates) {
            min = min < i ? min : i;
        }
        backtrracking(candidates, target, 0, min);
        return result;
    }

    public void backtrracking(int[] candidates, int target, int idx, int min) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < min) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrracking(candidates, target - candidates[i], i, min);
            list.remove(list.size() - 1);
        }
    }
}
