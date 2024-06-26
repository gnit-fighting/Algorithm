package daiMaSuiXiangLu.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return result;
    }

    public void backTracking(int startidx, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startidx; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(i + 1, n, k);
            path.removeLast();
        }
    }
}
