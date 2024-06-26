package Hot100.easy;

import java.util.HashMap;
import java.util.Map;

public class _1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null || nums.length==0){
            return  res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.get(temp)!=null){
                res[0] = i;
                res[1] = map.get(temp);
                return  res;
            }else {
                map.put(nums[i],i);
            }
        }
        return  res ;
    }
}
