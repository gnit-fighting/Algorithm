package Hot100.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _169 {
    //多数元素
    //三种方法：1.哈希计数 2.排序取中值法 3.摩尔投票法

    //1.哈希计数法
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> integers = map.keySet();
        for (Integer i : integers) {
            if (map.get(i) > nums.length >> 1) {
                return i;
            }
        }
        return -1;
    }

    //2.排序取中法
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    //摩尔投票法
    public int majorityElement(int[] nums) {
        int cand = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==cand){
                cnt++;
            }else {
                if(--cnt==0){
                    cand =nums[i];
                    cnt=1;
                }
            }
        }
        return cand;
    }

}
