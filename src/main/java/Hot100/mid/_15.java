package Hot100.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //对 nums排序
        Arrays.sort(nums);

        for (int a = 0; a <= nums.length-3; a++) {
            if (nums[a] > 0) {//剪枝
                break;
            }
            if (a - 1 >= 0 && nums[a] == nums[a - 1]) {//对 a去重
                continue;
            }
            int left = a + 1;
            int right = nums.length - 1;
            int tofind = 0 - nums[a];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == tofind) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    //对 left 和 right 去重
                    while (right>left && right > 0 &&right+1<nums.length&& nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left<right && left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > tofind) {
                    right--;
                } else if (sum < tofind) {
                    left++;
                }


            }

        }
        return result;

    }
}
