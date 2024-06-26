package daiMaSuiXiangLu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int pathSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 求k 个数的组合，数字在 1-9的范围内，和为 n
        // 回溯
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int start) {
        //对组合和剪枝，当 path中的元素的和大于 n 了，就没有再往下遍历的必要了
        if (pathSum > n) {
            return;
        }
        if (path.size() == k) {
            if (pathSum == n) {
                result.add(new ArrayList<>(path));

            }
            return;
        }

        //小优化：对 i 的范围剪枝
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            pathSum += i;
            backtracking(n, k, i + 1);
            path.removeLast();
            pathSum -= i;
        }
    }
}
