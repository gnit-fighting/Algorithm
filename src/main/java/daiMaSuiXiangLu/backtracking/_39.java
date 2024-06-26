package daiMaSuiXiangLu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 */
public class _39 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //获取 candidates【】的最小值，回溯剪枝用
        int min = Integer.MAX_VALUE;
        for (int i : candidates) {
            if (i < min) {
                min = i;
            }
        }
        backtracking(candidates, target, 0, min);
        return result;
    }

    public void backtracking(int[] candidates, int target, int idx, int min) {
        if (target == 0) {
            //收集结果
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < min) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i, min);
            list.remove(list.size() - 1);
        }
    }
}
