package Hot100.mid;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    List<List<Integer>> result;
    List<Integer> path = new ArrayList<>();
    int[] used;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        len = nums.length;
        used = new int[len];

        backtracking(nums);

        return result;
    }

    public void backtracking(int[] nums) {
        if (path.size() == len) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;

                //递归
                backtracking(nums);

                //回溯
                path.remove(path.size() - 1);
                used[i] = 0;
            }

        }
    }
}
